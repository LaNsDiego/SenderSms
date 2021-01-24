package com.example.sendersms.views.kardex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.sendersms.R;
import com.example.sendersms.helpers.RecyclerBuilder;
import com.example.sendersms.kardexdetail.KardexDetailAdapter;
import com.example.sendersms.kardexdetail.KardexDetailModel;
import com.example.sendersms.views.HistorialActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class DetailKardexFragment extends Fragment {
    public View root;
    MaterialToolbar toolbar;
    Boolean isVisibleSearch = false;
    ChipGroup cgrFiltersDetailKardex;
    ConstraintLayout ctlFilters;
    TextInputEditText tieSearchDetailKardex;
    List<KardexDetailModel> listKardexDetail;
    ExtendedFloatingActionButton fabNewDetailKardex;

    public DetailKardexFragment() {
        // Required empty public constructor
    }

    public static DetailKardexFragment newInstance() {
        DetailKardexFragment fragment = new DetailKardexFragment();
        return fragment;
//    }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_detail_kardex, container, false);
        tieSearchDetailKardex = root.findViewById(R.id.tie_search_detail_kardex);
        cgrFiltersDetailKardex = root.findViewById(R.id.cgr_filters_detail_kardex);
        ctlFilters = root.findViewById(R.id.ctl_filters);
        fabNewDetailKardex = root.findViewById(R.id.fab_new_kardex);
        fabNewDetailKardex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_new_detail_kardex);
            }
        });
        listKardexDetail = new ArrayList<>();
        KardexDetailAdapter adapterKardexDetail = new KardexDetailAdapter(listKardexDetail);
        RecyclerView recyclerKardexDetail = root.findViewById(R.id.recyclerview_kardex_detail);
        RecyclerBuilder.build(recyclerKardexDetail,adapterKardexDetail);
        return root;
    }

}