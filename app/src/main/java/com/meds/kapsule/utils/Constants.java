package com.meds.kapsule.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

public class Constants {

    //public static final String ENV = "production";
    public static final String ENV = "development"; // todo change to production for production
    public static final boolean isDev = true; // todo change to false for production
    public static final String dev = "dev_"; // todo change to null/empty for production

    // TAG
    public static final String TAG = "capsule";
    public static String loading = "Loading...";

    // Company Details
    public static String companyMobileNumber = "8072223041";
    public static String companyMailID = "marmuazhar@gmail.com";
    public static String companyWhatsapp = "8072223041";


    /* Medicine API */
    public static final String _ims_categorylist_authKey = "6ad136e8fd3ccc8b693df867c5a44862";
    public static final String _ims_otherlist_authkey = "0ee82e248b47f814531ad3fa732b0b78";

    /* Firebase AUTH */
    public static final FirebaseAuth AUTH = FirebaseAuth.getInstance();

    public static final String _api2Factor = "52345536-682f-11e8-a895-0200cd936042";


    /* Camera Constants*/
    public static int REQUEST_CAMERA = 1;
    public static int REQUEST_GALLERY = 2;
    public static int RESULT_INTENT = 100;

    public static final String prefixOrderID = "Order id #";

    public static final String image = "image";
    public static final String camera = "camera";
    public static final String gallery = "gallery";

    public static final String result = "result";

    /**/
    static final String LOGIN = "Login";
    static final String TOKEN = "token";
    public static String PRESCRIPTION_PHOTO = "photo";
    public static PhoneAuthProvider.ForceResendingToken OTP_RESEND_TOKEN = null;


    public static final String verificationID = "verificationID";


    // broadcast receiver intent filters
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // carousel ---> RT
    public static final String carouselList = "carousel";
    public static final String lastOrderIDRT = "lastOrderID";
    public static final String url = "url";
    public static final String link = "link";

    // usersList ---> FS
    public static final String usersList = "usersList";
    public static final String deviceToken = "deviceToken";
    public static final String phoneNumber = "phoneNumber";
    public static final String userName = "userName";
    public static final String age = "age";
    public static final String emailID = "emailID";
    public static final String referredCode = "referredCode";
    public static final String address = "address";
    public static final String flatNo = "flatNo";
    public static final String position = "position";
    public static final String street = "street";
    public static final String pincode = "pincode";
    public static final String customer = "customer";
    public static final String locality = "locality";
    public static final String landmark = "landmark";
    public static final String city = "city";
    public static final String state = "state";
    public static final String recentlyUsed = "recentlyUsed";
    public static final String name = "name";
    public static final String phone = "phone";
    public static final String place = "place";
    public static final String accountBalance = "accountBalance";


    // prescription order
    public static final String orderList = "orderList";
    public static final String prescriptions = "prescriptions";
    public static final String prescriptionType = "prescriptionType";
    public static final String typeOfOrder = "typeOfOrder";
    public static final String medicineList = "medicineList";
    public static final String medSpecify = "medSpecify";
    public static final String userID = "userID";
    public static final String timeStamp = "timeStamp";
    public static final String orderID = "orderID";
    public static final String status = "status";

    // status types
    public static final String newOrder = "new";
    public static final String ongoing = "ongoing";
    public static final String completed = "completed";
    public static final String cancelled = "cancelled";

    // prescription order type
    public static final String orderAll = "orderAll";
    public static final String orderSpecify = "orderSpecify";
    public static final String orderCall = "orderCall";

    // stockList --> FS
    public static String stockList = "stockList";

    // servingPincodeList --> FS
    public static String servingPincodeList = "servingPincodeList";

    // deliveryBoyList --> FS
    public static final String deliveryBoyList = "deliveryBoyList";

    // intent key
    public static String editProfileIntent = "editProfileIntent";
    public static String categoryID = "categoryID";
    public static String categoryName = "categoryName";
    public static String productID = "productID";
    public static String productName = "productName";
    public static String productPrice = "productPrice";
    public static String productDiscountPrice = "productDiscountPrice";
    public static String productQTY = "productQTY";

    public static String cart = "cart";
}
