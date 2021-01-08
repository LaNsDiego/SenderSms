package com.example.sendersms.kardexdetail;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

import java.util.List;
import java.util.zip.Inflater;

public class KardexDetailAdapter extends RecyclerView.Adapter<KardexDetailHolder> {

    List<KardexDetailModel> listKardexDetail;

    public KardexDetailAdapter(List<KardexDetailModel> listKardexDetail) {
        this.listKardexDetail = listKardexDetail;
    }

    @NonNull
    @Override
    public KardexDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_kardex, parent, false);
        return new KardexDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KardexDetailHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listKardexDetail.size();
    }
}
