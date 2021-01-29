package com.example.sendersms.kardexdetail;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

public class ItemDetailKardexHolder extends RecyclerView.ViewHolder {

    public TextView txvName,txvQuantity,txvPrice,txvSubtotal;
    public ItemDetailKardexHolder(@NonNull View itemView) {
        super(itemView);
        txvName = itemView.findViewById(R.id.txv_product_name);
        txvQuantity = itemView.findViewById(R.id.txv_product_price);
        txvPrice = itemView.findViewById(R.id.txv_product_quantity);
        txvSubtotal = itemView.findViewById(R.id.txv_product_subtotal);
    }
}
