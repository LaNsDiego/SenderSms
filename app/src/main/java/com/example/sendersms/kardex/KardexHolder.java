package com.example.sendersms.kardex;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

public class KardexHolder extends RecyclerView.ViewHolder {

    public ConstraintLayout itemKardex;
    public TextView txvPeriod , txvRuc , txvDescription , txvUnit ,txvEntity;
    public KardexHolder(@NonNull View itemView) {
        super(itemView);
        itemKardex = itemView.findViewById(R.id.item_recycler_kardex);
        txvPeriod = itemView.findViewById(R.id.txv_period);
        txvRuc = itemView.findViewById(R.id.txv_ruc);
        txvDescription = itemView.findViewById(R.id.txv_description);
        txvUnit = itemView.findViewById(R.id.txv_unit);
        txvEntity = itemView.findViewById(R.id.txv_entity);
    }
}
