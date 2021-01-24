package com.example.sendersms.views.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;


public class S2IdentificationFragment extends Fragment {
    public S2IdentificationFragment() {
        // Required empty public constructor
    }


    public static S2IdentificationFragment newInstance() {
        S2IdentificationFragment fragment = new S2IdentificationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s2_identification, container, false);
    }
}