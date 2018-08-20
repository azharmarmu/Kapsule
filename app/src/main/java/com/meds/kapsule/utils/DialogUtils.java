package com.meds.kapsule.utils;

import android.content.Context;
import android.widget.Toast;

public class DialogUtils {

    /*private static ACProgressFlower mProgressDialog;

    public static void showProgressDialog(Context context) {
        mProgressDialog = new ACProgressFlower.Builder(context)
                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                .themeColor(Color.WHITE)
                .text("Loading")
                .fadeColor(Color.DKGRAY).build();
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public static void dismissProgressDialog() {
        if (mProgressDialog != null) {
            if (mProgressDialog.isShowing())
                mProgressDialog.cancel();
        }
    }*/

    public static void appToastShort(Context context, String Message) {
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }

}
