package com.example.sendersms.kardex;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

public class KardexHolder extends RecyclerView.ViewHolder {

    public ConstraintLayout itemKardex;
    public KardexHolder(@NonNull View itemView) {
        super(itemView);
        itemKardex = itemView.findViewById(R.id.item_recycler_kardex);
    }
}
