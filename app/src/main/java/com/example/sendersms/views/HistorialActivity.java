package com.example.sendersms.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sendersms.R;
import com.example.sendersms.kardexdetail.KardexDetailAdapter;
import com.example.sendersms.kardexdetail.KardexDetailModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class HistorialActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    Boolean isVisibleSearch = false;
    TextInputEditText tieSearchDetailKardex;
    List<KardexDetailModel> listKardexDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        tieSearchDetailKardex = findViewById(R.id.tie_search_detail_kardex);
        listKardexDetail = new ArrayList<>();
        listKardexDetail.add(new KardexDetailModel());
        listKardexDetail.add(new KardexDetailModel());
        listKardexDetail.add(new KardexDetailModel());
        listKardexDetail.add(new KardexDetailModel());
        listKardexDetail.add(new KardexDetailModel());
        listKardexDetail.add(new KardexDetailModel());
        KardexDetailAdapter adapterKardexDetail = new KardexDetailAdapter(listKardexDetail);


        RecyclerView recyclerKardexDetail = findViewById(R.id.recyclerview_kardex_detail);
        LinearLayoutManager llms = new LinearLayoutManager(HistorialActivity.this);
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerKardexDetail.getContext(),
                llms.getOrientation());
        recyclerKardexDetail.addItemDecoration(dividerItemDecoration);
        recyclerKardexDetail.setLayoutManager(llms);
        recyclerKardexDetail.setAdapter(adapterKardexDetail);

        //TOOLBAR
        toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final int itemId = item.getItemId();
                if(itemId == R.id.action_search_kardex){
                    toggleSearhInput();
                    return true;
                }
                return false;
            }
        });
    }

    private void toggleSearhInput(){

        if(isVisibleSearch){
            tieSearchDetailKardex.setVisibility(View.GONE);
            toolbar.getMenu().getItem(0).setIcon(R.drawable.ic_baseline_search_24);
        }else{
            tieSearchDetailKardex.setVisibility(View.VISIBLE);
            toolbar.getMenu().getItem(0).setIcon(R.drawable.ic_baseline_close_24);
        }
        isVisibleSearch = !isVisibleSearch;
    }
}