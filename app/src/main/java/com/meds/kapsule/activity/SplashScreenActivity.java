package com.meds.kapsule.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.meds.kapsule.R;
import com.meds.kapsule.firebase.FirebaseDB;
import com.meds.kapsule.model.CarouselModel;
import com.meds.kapsule.utils.CommonUtils;
import com.meds.kapsule.utils.Constants;
import com.meds.kapsule.utils.DialogUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.fabric.sdk.android.Fabric;

@SuppressWarnings("unchecked")
public class SplashScreenActivity extends AppCompatActivity {

    SplashScreenActivity _this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _this = SplashScreenActivity.this;
        CommonUtils.setFullScreen(_this);

        Fabric.with(this, new Crashlytics());
        carouselSetup();
    }

    private void carouselSetup() {
        new FirebaseDB()
                .carouselListRT
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null) {

                            HashMap<String, Object> carouselMap = (HashMap<String, Object>) dataSnapshot.getValue();

                            List<CarouselModel> carouselList = new ArrayList<>();
                            for (String key : carouselMap.keySet()) {
                                HashMap<String, Object> carousel = (HashMap<String, Object>) carouselMap.get(key);

                                String url = carousel.get(Constants.url).toString();
                                String link = carousel.get(Constants.link).toString();
                                carouselList.add(new CarouselModel(url, link));
                            }
                            Intent mainIntent = new Intent(_this, MainActivity.class);
                            mainIntent.putExtra(Constants.carouselList, (Serializable) carouselList);
                            startActivity(mainIntent);
                            overridePendingTransition(R.anim.right_in, R.anim.left_out);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        DialogUtils.appToastShort(_this, databaseError.getMessage());
                    }
                });
    }
}
