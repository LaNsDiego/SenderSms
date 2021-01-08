package com.example.sendersms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.kardex.KardexAdapter;
import com.example.sendersms.kardex.KardexModel;
import com.example.sendersms.kardexdetail.KardexDetailAdapter;
import com.example.sendersms.kardexdetail.KardexDetailModel;
import com.example.sendersms.views.HistorialActivity;

import java.util.ArrayList;
import java.util.List;

public class KardexFragment extends Fragment {

    List<KardexModel> listKardex;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_kardex, container, false);
        listKardex = new ArrayList<>();
        listKardex.add(new KardexModel());
        listKardex.add(new KardexModel());
        listKardex.add(new KardexModel());
        listKardex.add(new KardexModel());
        listKardex.add(new KardexModel());
        listKardex.add(new KardexModel());
        KardexAdapter adapterKardex = new KardexAdapter(listKardex);


        RecyclerView recyclerKardex = root.findViewById(R.id.recycler_kardex);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerKardex.getContext(),
                llms.getOrientation());
        recyclerKardex.addItemDecoration(dividerItemDecoration);
        recyclerKardex.setLayoutManager(llms);
        recyclerKardex.setAdapter(adapterKardex);

        return root;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.btn_send_campain).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(KardexFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
    }
}