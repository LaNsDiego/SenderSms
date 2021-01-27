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
    KardexInterface.KardexItemListener listener;
    public KardexAdapter(List<KardexModel> listKardex ,KardexInterface.KardexItemListener listener ) {
        this.listKardex = listKardex;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KardexHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kardex, parent, false);
        return new KardexHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KardexHolder holder, int position) {
        final KardexModel objKardex = listKardex.get(position);
        holder.txvPeriod.setText(objKardex.getPeriod());
        holder.txvDescription.setText(objKardex.getDescription());
        holder.txvEntity.setText(objKardex.getEntity());
        holder.txvRuc.setText(objKardex.getRuc());
        holder.txvUnit.setText(objKardex.getCodeUnit());
        holder.itemKardex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickItemKardex(objKardex);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKardex.size();
    }
}
