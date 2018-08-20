package com.meds.kapsule.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.meds.kapsule.R;
import com.meds.kapsule.fragment.LoginFragment;
import com.meds.kapsule.fragment.RegisterFragment;

public class LoginRegisterActivity extends AppCompatActivity {

    LoginRegisterActivity _this;
    boolean is_frag_login_shown = true;
    FragmentTransaction transaction;
    TextView tvLoginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _this = LoginRegisterActivity.this;
        setContentView(R.layout.activity_login_register);

        tvLoginRegister = findViewById(R.id.tvLoginRegister);

        initialFragmentSetup();

        tvLoginRegister.setOnClickListener(view -> {
            transaction = getSupportFragmentManager().beginTransaction();

            if (is_frag_login_shown) {
                tvLoginRegister.setText(getString(R.string.do_you_have_an_account_login));
                transaction.replace(R.id.loginRegisterFragment, new RegisterFragment());
                is_frag_login_shown = false;
            } else {
                tvLoginRegister.setText(getString(R.string.don_t_have_an_account_register));
                transaction.replace(R.id.loginRegisterFragment, new LoginFragment());
                is_frag_login_shown = true;
            }
            transaction.commit();
        });

    }

    private void initialFragmentSetup() {
        transaction = getSupportFragmentManager().beginTransaction();
        tvLoginRegister.setText(getString(R.string.don_t_have_an_account_register));
        transaction.add(R.id.loginRegisterFragment, new LoginFragment());
        is_frag_login_shown = true;
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(_this, MainActivity.class);
        startActivity(mainIntent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
        finish();
    }
}
