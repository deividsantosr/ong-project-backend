package com.nogs.ongprojectbackend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.nogs.ongprojectbackend.model.dao.MobileConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class MobileConfigService {

    public static final String COLLECTION_NAME = "mobileConfigs";

    public String saveMobileConfigDetails(MobileConfig mobileConfig) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        mobileConfig.setId(UUID.randomUUID().toString());
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(mobileConfig.getId()).set(mobileConfig);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public MobileConfig getMobileConfigDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        MobileConfig mobileConfig = null;

        if (document.exists()) {
            mobileConfig = document.toObject(MobileConfig.class);
            return mobileConfig;
        } else {
            return null;
        }
    }

    public List<MobileConfig> getMobileConfigDetails() throws InterruptedException, ExecutionException {
        List<MobileConfig> mobileConfigList = new ArrayList<>();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            mobileConfigList.add(document.toObject(MobileConfig.class));
        }

        return mobileConfigList;
    }

    public String updateMobileConfigDetails(MobileConfig mobileConfig) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(mobileConfig.getId()).set(mobileConfig);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteMobileConfig(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(id).delete();

        return "Document ID " + id + " has been deleted";
    }
}