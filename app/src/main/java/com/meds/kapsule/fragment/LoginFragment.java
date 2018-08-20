package com.meds.kapsule.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meds.kapsule.R;
import com.meds.kapsule.utils.DialogUtils;



public class LoginFragment extends Fragment implements View.OnClickListener {

    public LoginFragment() {
        // Required empty public constructor
    }

    View rootView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        FloatingActionButton loginFAB = rootView.findViewById(R.id.fabLogin);
        TextView tvForgotPassword = rootView.findViewById(R.id.tvForgotPassword);

        loginFAB.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabLogin:
                DialogUtils.appToastShort(getActivity(), "Login");
                break;
            case R.id.tvForgotPassword:
                DialogUtils.appToastShort(getActivity(), "Forgot Password");
                break;
        }
    }
}
