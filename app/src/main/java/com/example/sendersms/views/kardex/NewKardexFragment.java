package com.example.sendersms.views.kardex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.sendersms.R;
import com.example.sendersms.firebase.Firestore;
import com.example.sendersms.kardex.KardexModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewKardexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewKardexFragment extends Fragment {

    View root;
    MaterialAutoCompleteTextView matUnit,matPeriod;
    TextInputEditText tieEntity,tieDescription,tieRuc;
    MaterialButton btnCreate;
    public NewKardexFragment() {
        // Required empty public constructor
    }

    public static NewKardexFragment newInstance(String param1, String param2) {
        NewKardexFragment fragment = new NewKardexFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_new_kardex, container, false);
        matUnit = root.findViewById(R.id.mat_unit);
        matPeriod = root.findViewById(R.id.mat_period);
        tieEntity = root.findViewById(R.id.tie_entity);
        tieDescription = root.findViewById(R.id.tie_description);
        tieRuc = root.findViewById(R.id.tie_ruc);
        btnCreate = root.findViewById(R.id.btn_create_new_kardex);
        ArrayAdapter<String> periods = new ArrayAdapter<>(root.getContext(),R.layout.support_simple_spinner_dropdown_item);
        periods.add("2021-I");
        periods.add("2021-II");
        matPeriod.setAdapter(periods);
        ArrayAdapter<String> units = new ArrayAdapter<>(root.getContext(),R.layout.support_simple_spinner_dropdown_item);
        units.add("Unidad");
        units.add("Kg");
        matUnit.setAdapter(units);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createKardex();
            }
        });

        return root;
    }

    private void createKardex(){
        DocumentReference newDocKardex = Firestore.getCollectionKardex().document();
        KardexModel objNewKardex = new KardexModel();
        objNewKardex.setId(newDocKardex.getId());
        objNewKardex.setStoreId("1");
        objNewKardex.setCodeUnit(matUnit.getText().toString());
        objNewKardex.setDescription(tieDescription.getText().toString());
        objNewKardex.setRuc(tieRuc.getText().toString());
        objNewKardex.setPeriod(matPeriod.getText().toString());
        objNewKardex.setEntity(tieEntity.getText().toString());
        newDocKardex.set(objNewKardex).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Navigation.findNavController(root).navigate(R.id.nav_kardex);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });

    }
}