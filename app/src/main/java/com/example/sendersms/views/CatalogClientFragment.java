package com.example.sendersms.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sendersms.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatalogClientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatalogClientFragment extends Fragment {

    public CatalogClientFragment() {
        // Required empty public constructor
    }

    public static CatalogClientFragment newInstance(String param1, String param2) {
        CatalogClientFragment fragment = new CatalogClientFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View inflate = inflater.inflate(R.layout.fragment_catalog_client, container, false);
        ImageView img = inflate.findViewById(R.id.imv_catalog_client);

        Glide.with(inflate).load(R.drawable.mesa_de_trabajo__1).circleCrop().into(img);
        return inflate;
    }
}