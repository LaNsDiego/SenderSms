package com.example.sendersms.views.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;

public class S4ConfirmFragment extends Fragment {

    public S4ConfirmFragment() {
        // Required empty public constructor
    }

    public static S4ConfirmFragment newInstance() {
        S4ConfirmFragment fragment = new S4ConfirmFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s4_confirm, container, false);
    }
}