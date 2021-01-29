package com.example.sendersms.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreHolder> {
    List<StoreModel> list;

    public StoreAdapter(List<StoreModel> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        return new StoreHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
