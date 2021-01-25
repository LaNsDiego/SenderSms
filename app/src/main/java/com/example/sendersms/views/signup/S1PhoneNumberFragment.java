package com.example.sendersms.views.signup;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class S1PhoneNumberFragment extends Fragment {

    View root;
    TextInputEditText tiePhoneNumber;
    MaterialButton btnNext;
    public static S1PhoneNumberFragment newInstance() {
        return new S1PhoneNumberFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.s1_phone_number_fragment, container, false);
        tiePhoneNumber = root.findViewById(R.id.tie_phone_number);
        btnNext = root.findViewById(R.id.btn_next_s2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return root;
    }


}