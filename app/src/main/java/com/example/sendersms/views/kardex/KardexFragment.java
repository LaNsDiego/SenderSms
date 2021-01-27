package com.example.sendersms.views.kardex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;
import com.example.sendersms.firebase.Firestore;
import com.example.sendersms.helpers.RecyclerBuilder;
import com.example.sendersms.kardex.KardexAdapter;
import com.example.sendersms.kardex.KardexInterface;
import com.example.sendersms.kardex.KardexModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KardexFragment extends Fragment implements KardexInterface.KardexItemListener {
    View root;
    List<KardexModel> listKardex;
    CircularProgressIndicator cpiKardex;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_kardex, container, false);
        listKardex = new ArrayList<>();
        cpiKardex = root.findViewById(R.id.cpi_kardex);
        ExtendedFloatingActionButton fabNewKardex = root.findViewById(R.id.fab_new_kardex);
        fabNewKardex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_new_kardex);
            }
        });

        getListKardex();
        return root;
    }

    @Override
    public void onClickItemKardex(KardexModel objKardex) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("objKardex",objKardex);
        Navigation.findNavController(root).navigate(R.id.nav_detail_kardex,bundle);
    }

    private void render(List<KardexModel> list){
        cpiKardex.setVisibility(View.GONE);
        KardexAdapter adapterKardex = new KardexAdapter(list , this);
        RecyclerView recyclerKardex = root.findViewById(R.id.recycler_kardex);
        RecyclerBuilder.build(recyclerKardex,adapterKardex);
    }

    private void getListKardex(){
        Firestore.getCollectionKardex().get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments()){
                    listKardex.add(snapshot.toObject(KardexModel.class));
                }
                render(listKardex);
            }
        });
    }

}