package com.example.sendersms.sell;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SellHolder extends RecyclerView.ViewHolder {

    FloatingActionButton btnAddProduct;
    public SellHolder(@NonNull View itemView) {
        super(itemView);
        btnAddProduct = itemView.findViewById(R.id.btn_add_product);
    }
}
