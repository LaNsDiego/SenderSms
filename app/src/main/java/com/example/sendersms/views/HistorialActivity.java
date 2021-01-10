package com.example.sendersms.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sendersms.R;
import com.example.sendersms.kardexdetail.KardexDetailAdapter;
import com.example.sendersms.kardexdetail.KardexDetailModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class HistorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

    }

    private void toggleSearhInput(){

//        if(isVisibleSearch){
//            tieSearchDetailKardex.setVisibility(View.GONE);
//            ctlFilters.setVisibility(View.GONE);
//            ctlFilters.animate().alpha(0.0f).setDuration(1000);
//            toolbar.getMenu().getItem(0).setIcon(R.drawable.ic_baseline_search_24);
//        }else{
//            tieSearchDetailKardex.setVisibility(View.VISIBLE);
//            ctlFilters.setVisibility(View.VISIBLE);
//            ctlFilters.animate().alpha(1.0f).setDuration(1000);
//            toolbar.getMenu().getItem(0).setIcon(R.drawable.ic_baseline_close_24);
//        }
//        isVisibleSearch = !isVisibleSearch;
    }
}