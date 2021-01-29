package com.example.sendersms.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;
import com.example.sendersms.helpers.RecyclerBuilder;
import com.example.sendersms.store.StoreAdapter;
import com.example.sendersms.store.StoreModel;

import java.util.ArrayList;
import java.util.List;


public class StoreFragment extends Fragment {
    View root;
    public StoreFragment() {
        // Required empty public constructor
    }

    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_store, container, false);
        RecyclerView recycler = root.findViewById(R.id.recycler_store);
        List<StoreModel> list = new ArrayList<>();
        list.add(new StoreModel());
        list.add(new StoreModel());
        list.add(new StoreModel());
        final StoreAdapter storeAdapter = new StoreAdapter(list);
        RecyclerBuilder.build(recycler,storeAdapter);
        return root;
    }
}