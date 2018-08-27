package com.meds.kapsule.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.meds.kapsule.R;
import com.meds.kapsule.firebase.FirebaseDB;
import com.meds.kapsule.model.CarouselModel;
import com.meds.kapsule.utils.Constants;
import com.meds.kapsule.utils.DialogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("unchecked")
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PermissionListener, PermissionRequestErrorListener {

    MainActivity _this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _this = MainActivity.this;
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            updateCarousel((List<CarouselModel>) Objects.requireNonNull(bundle.get(Constants.carouselList)));
        }

        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        menuView(header);

        bodyView();
    }

    private void menuView(View header) {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ImageView menu_hammer = findViewById(R.id.menu_hammer);
        menu_hammer.setOnClickListener(view -> drawer.openDrawer(Gravity.START));

        LinearLayout welcomeLayout = header.findViewById(R.id.welcomeLayout);
        LinearLayout profileLayout = header.findViewById(R.id.profileLayout);
        welcomeLayout.setVisibility(View.GONE);
        profileLayout.setVisibility(View.GONE);

        if (Constants.AUTH.getCurrentUser() != null) {
            profileLayout.setVisibility(View.VISIBLE);
        } else {
            welcomeLayout.setVisibility(View.VISIBLE);
        }

        welcomeLayout.setOnClickListener(view -> {
            Intent i = new Intent(_this, LoginRegisterActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            finish();
        });

        ImageView menu_search = findViewById(R.id.menu_search);
        menu_search.setOnClickListener(view -> startActivity(new Intent(_this,SearchMedicineActivity.class)));
    }


    private void bodyView() {
        //todo
    }

    private void updateCarousel(List<CarouselModel> carouselList) {

        if (carouselList.size() > 0) {
            SliderLayout sliderShow = findViewById(R.id.imgSlider);
            PagerIndicator customIndicator = findViewById(R.id.customIndicator);

            sliderShow.removeAllSliders();
            sliderShow.setCustomIndicator(customIndicator);

            for (int i = 0; i < carouselList.size(); i++) {

                final CarouselModel carouselModel = carouselList.get(i);

                DefaultSliderView sliderView = new DefaultSliderView(_this);

                sliderView.empty(R.drawable.placeholder_banner);
                sliderView.image(carouselModel.getUrl());

                sliderShow.addSlider(sliderView);

                sliderView.setOnSliderClickListener(slider -> {
                    try {
                        DialogUtils.appToastShort(_this, carouselModel.getLink());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings({"StatementWithEmptyBody", "unused"})
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void call(View view) {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(this)
                .check();
    }

    public void sms(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);
    }

    public void mail(View view) {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{Constants.companyMailID});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Medicine Details");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(intent);

    }

    public void whatsapp(View view) {
        PackageManager pm = getPackageManager();

        try {
            // Raise exception if whatsapp doesn't exist
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(Constants.companyWhatsapp) + "@s.whatsapp.net");
            startActivity(sendIntent);
        } catch (PackageManager.NameNotFoundException e) {
            DialogUtils.appToastShort(_this, "Please install whatsapp app");
        }
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Constants.companyMobileNumber));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {

    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
        token.continuePermissionRequest();
    }

    @Override
    public void onError(DexterError error) {
        Log.e("Dexter", error.toString());
        DialogUtils.appToastShort(_this, error.toString());
    }

    public void prescriptionOrder(View view) {
        startActivity(new Intent(_this, PrescriptionOrderActivity.class));
    }
}
