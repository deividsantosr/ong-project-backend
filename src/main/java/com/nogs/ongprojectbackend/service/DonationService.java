package com.nogs.ongprojectbackend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.nogs.ongprojectbackend.model.dao.Donation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class DonationService {

    public static final String COLLECTION_NAME = "donations";

    public String saveDonationDetails(Donation donation) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        donation.setId(UUID.randomUUID().toString());
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(donation.getId()).set(donation);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Donation getDonationDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Donation donation = null;

        if (document.exists()) {
            donation = document.toObject(Donation.class);
            return donation;
        } else {
            return null;
        }
    }

    public List<Donation> getDonationDetails() throws InterruptedException, ExecutionException {
        List<Donation> donationList = new ArrayList<>();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            donationList.add(document.toObject(Donation.class));
        }

        return donationList;
    }

    public String updateDonationDetails(Donation donation) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(donation.getId()).set(donation);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteDonation(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(id).delete();

        return "Document ID " + id + " has been deleted";
    }
}