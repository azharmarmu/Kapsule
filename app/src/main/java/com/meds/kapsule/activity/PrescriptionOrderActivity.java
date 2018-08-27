package com.meds.kapsule.activity;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;

import com.meds.kapsule.R;

import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;


public class PrescriptionOrderActivity extends AppCompatActivity {

    PrescriptionOrderActivity _this;

    RelativeLayout attachedPrescriptionLayout, attachedMedicineLayout;
    RadioGroup attachedPrescriptionTypeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _this = PrescriptionOrderActivity.this;
        setContentView(R.layout.activity_prescription_order);

        initViews();

        CheckBox cbSOD = findViewById(R.id.cbSOD);
        cbSOD.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            attachedPrescriptionLayout.setVisibility(View.GONE);
            attachedMedicineLayout.setVisibility(View.GONE);
            attachedPrescriptionTypeLayout.setVisibility(View.GONE);
            if (isChecked) {
                attachedMedicineLayout.setVisibility(View.VISIBLE);
            } else {
                attachedPrescriptionLayout.setVisibility(View.VISIBLE);
                attachedPrescriptionTypeLayout.setVisibility(View.VISIBLE);
            }

        });


    }

    private void initViews() {
        attachedPrescriptionLayout = findViewById(R.id.attachedPrescriptionLayout);
        attachedMedicineLayout = findViewById(R.id.attachedMedicineLayout);
        attachedPrescriptionTypeLayout = findViewById(R.id.attachedPrescriptionTypeLayout);
    }


    public void addPrescription(View view) {
        final Dialog dialog = new Dialog(this, R.style.DialogTheme);
        dialog.setContentView(R.layout.dialog_image_settings);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = Objects.requireNonNull(window).getAttributes();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;

        // set the custom dialog components - text and button
        TextView gallery = dialog.findViewById(R.id.dialog_gallery);
        TextView camera = dialog.findViewById(R.id.dialog_camera);

        gallery.setOnClickListener(view1 -> {
            //galleryIntent();
            dialog.dismiss();
        });

        camera.setOnClickListener(view12 -> {
            //cameraIntent();
            dialog.dismiss();
        });

        dialog.show();
    }

    public void addMedicine(View view) {
        final Dialog dialog = new Dialog(this, R.style.DialogTheme);
        dialog.setContentView(R.layout.activity_search_medicine);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = Objects.requireNonNull(window).getAttributes();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.BOTTOM;

        // set the custom dialog components - text and button
        final EditText etSearchMedicine = dialog.findViewById(R.id.etSearchMedicine);
        etSearchMedicine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0){
                    //getSearchResults(dialog, editable.toString());
                }

            }
        });
        dialog.show();
    }

    public void changeAddress(View view) {
        //startActivityForResult(new Intent(_this, ChooseAddressActivity.class), 3);
    }


    public void confirmOrder(View view) {
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> _this.onSuperBackPressed())
                .setNegativeButton("No", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onSuperBackPressed() {
        super.onBackPressed();
    }

}
