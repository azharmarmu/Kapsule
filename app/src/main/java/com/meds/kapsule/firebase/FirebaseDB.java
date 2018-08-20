package com.meds.kapsule.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.meds.kapsule.utils.Constants;


/**
 * Created by azharuddin on 4/8/17.
 */

public class FirebaseDB {

    private final FirebaseDatabase dbRT = FirebaseDatabase.getInstance();
    private final FirebaseFirestore dbFS = FirebaseFirestore.getInstance();
    private static FirebaseStorage dbST = FirebaseStorage.getInstance();

    /* RealTime */
    private final DatabaseReference RT_ENVIRONMENT = dbRT.getReference(Constants.ENV);
    public final DatabaseReference carouselListRT = RT_ENVIRONMENT.child(Constants.carouselList);
    public final DatabaseReference lastOrderIDRT = RT_ENVIRONMENT.child(Constants.lastOrderIDRT);

    /* Fire Store */
    /*------------------------------------ STATIC ------------------------------------------------*/
    //public final CollectionReference servingPincodeFS = dbFS.collection(Constants.servingPincodeList);

    /*------------------------------------ DYNAMIC -----------------------------------------------*/
    //public final CollectionReference userFS = dbFS.collection(Constants.dev + Constants.usersList);
    //public final CollectionReference orderListFS = dbFS.collection(Constants.dev + Constants.orderList);
    //public final CollectionReference stockListFS = dbFS.collection(Constants.dev + Constants.stockList);
    //public final CollectionReference deliveryBoyFS = dbFS.collection(Constants.dev + Constants.deliveryBoyList);

    /* Storage */
    //private final StorageReference ST_ENVIRONMENT = dbST.getReference(Constants.ENV);
    //public final StorageReference prescriptionST = ST_ENVIRONMENT.child(Constants.prescriptions);

}
