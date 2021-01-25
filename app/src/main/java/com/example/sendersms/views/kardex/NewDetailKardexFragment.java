package com.example.sendersms.views.kardex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;

public class NewDetailKardexFragment extends Fragment {

    View root;
    MaterialAutoCompleteTextView matTypeOperation , matTypeProof;
    TextInputEditText tieSerie , tieNumbeProof,tieQuantity,tiePrice,tieSubtotal;
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
        tieSerie = root.findViewById(R.id.tie_serie);
        tieSerie = root.findViewById(R.id.tie_number_proof);
        tieSerie = root.findViewById(R.id.tie_serie);
        return root;
    }
}