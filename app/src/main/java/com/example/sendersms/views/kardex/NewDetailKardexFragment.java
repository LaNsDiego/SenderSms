package com.example.sendersms.views.kardex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;

public class NewDetailKardexFragment extends Fragment {

    View root;
    public NewDetailKardexFragment() {
        // Required empty public constructor
    }

    public static NewDetailKardexFragment newInstance(String param1, String param2) {
        NewDetailKardexFragment fragment = new NewDetailKardexFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_new_detail_kardex, container, false);
        return root;
    }
}