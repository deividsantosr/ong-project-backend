package com.nogs.ongprojectbackend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.nogs.ongprojectbackend.model.dao.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class CategoryService {

    public static final String COLLECTION_NAME = "categories";

    public String saveCategoryDetails(Category category) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        category.setId(UUID.randomUUID().toString());
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(category.getId()).set(category);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Category getCategoryDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Category category = null;

        if (document.exists()) {
            category = document.toObject(Category.class);
            return category;
        } else {
            return null;
        }
    }

    public List<Category> getCategoryDetails() throws InterruptedException, ExecutionException {
        List<Category> categoryList = new ArrayList<>();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            categoryList.add(document.toObject(Category.class));
        }

        return categoryList;
    }

    public String updateCategoryDetails(Category category) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(category.getId()).set(category);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCategory(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(id).delete();

        return "Document ID " + id + " has been deleted";
    }
}