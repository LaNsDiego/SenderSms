package com.example.sendersms.views.kardex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendersms.R;
import com.example.sendersms.kardex.KardexModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;

public class NewDetailKardexFragment extends Fragment {

    View root;
    MaterialAutoCompleteTextView matTypeOperation , matTypeProof;
    TextInputEditText tieSerie , tieNumbeProof,tieQuantity,tiePrice,tieSubtotal;
    MaterialButton btnAddDetailKardex;
    TextView txvSubTotal;

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
        //FAB

        //Form Head
        matTypeOperation = root.findViewById(R.id.mat_type_operation);
        matTypeProof = root.findViewById(R.id.mat_type_proof);
        tieSerie = root.findViewById(R.id.tie_serie);
        tieNumbeProof = root.findViewById(R.id.tie_number_proof);

        //Form detail
        btnAddDetailKardex = root.findViewById(R.id.btn_add_detail_kardex);
        tieQuantity = root.findViewById(R.id.tie_quantity);
        tiePrice = root.findViewById(R.id.tie_price);
        txvSubTotal = root.findViewById(R.id.txv_subtotal);
        return root;
    }
}