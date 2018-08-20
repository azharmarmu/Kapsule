package com.meds.kapsule.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.meds.kapsule.R;
import com.meds.kapsule.utils.CommonUtils;

import io.fabric.sdk.android.Fabric;

public class SplashScreenActivity extends AppCompatActivity {

    SplashScreenActivity _this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _this = SplashScreenActivity.this;
        CommonUtils.setFullScreen(_this);

        Fabric.with(this, new Crashlytics());
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(_this, MainActivity.class);
            startActivity(mainIntent);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            finish();
        }, 2000);
    }
}
