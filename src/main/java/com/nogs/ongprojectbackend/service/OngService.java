package com.nogs.ongprojectbackend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.nogs.ongprojectbackend.model.dao.Ong;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class OngService {

    public static final String COLLECTION_NAME = "ongs";

    public String saveOngDetails(Ong ong) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ong.setId(UUID.randomUUID().toString());
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(ong.getId()).set(ong);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Ong getOngDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Ong ong = null;

        if (document.exists()) {
            ong = document.toObject(Ong.class);
            return ong;
        } else {
            return null;
        }
    }

    public List<Ong> getOngDetails() throws InterruptedException, ExecutionException {
        List<Ong> ongList = new ArrayList<>();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            ongList.add(document.toObject(Ong.class));
        }

        return ongList;
    }

    public String updateOngDetails(Ong ong) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(ong.getId()).set(ong);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteOng(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(id).delete();

        return "Document ID " + id + " has been deleted";
    }
}