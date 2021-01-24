package com.example.sendersms.firebase;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public abstract class Firestore {
    private static CollectionReference collectionUser;
    private static CollectionReference collectionProduct;
    private static CollectionReference collectionKardex;
    private static FirebaseFirestore db ;

    private Firestore() {}

    public static FirebaseFirestore getDb(){
        if(db == null){
//            FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
//                    .setPersistenceEnabled(true)
//                    .build();
            db = FirebaseFirestore.getInstance();
//            db.setFirestoreSettings(settings);
        }
        return db;
    }

    //COLECCION USUARIO
    public static CollectionReference getCollectionUser() {
        if(collectionUser == null){
            collectionUser = getDb().collection("users");
        }
        return collectionUser;
    }

    //COLECCION KARDEX
    public static CollectionReference getCollectionKardex() {
        if(collectionKardex == null){
            collectionKardex = getDb().collection("kardex");
        }
        return collectionKardex;
    }
}
