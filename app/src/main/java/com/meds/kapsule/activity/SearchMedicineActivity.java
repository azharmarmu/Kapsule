package com.meds.kapsule.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


import com.meds.kapsule.R;


public class SearchMedicineActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medicine);

        EditText etSearchMedicine = findViewById(R.id.etSearchMedicine);
        etSearchMedicine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getSearchResults(editable.toString());
            }
        });
    }

    private void getSearchResults(String query) {

    }

    /*private void populateSearchResult(List<SearchMedicineModel.Result> resultList) {
        RecyclerView.Adapter adapter = new SearchMedicineDetailedAdapter(this, resultList);
        RecyclerView recyclerView = findViewById(R.id.rvMedicineResult);
        recyclerView.removeAllViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);
    }*/
}
