package com.example.sendersms.views.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link S3UserDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class S3UserDataFragment extends Fragment {

    public S3UserDataFragment() {
        // Required empty public constructor
    }

    public static S3UserDataFragment newInstance(String param1, String param2) {
        S3UserDataFragment fragment = new S3UserDataFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s3_user_data, container, false);
    }
}