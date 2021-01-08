package com.example.sendersms.kardex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

import java.util.List;

public class KardexAdapter extends RecyclerView.Adapter<KardexHolder> {

    List<KardexModel> listKardex;

    public KardexAdapter(List<KardexModel> listKardex) {
        this.listKardex = listKardex;
    }

    @NonNull
    @Override
    public KardexHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kardex, parent, false);
        return new KardexHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KardexHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listKardex.size();
    }
}
