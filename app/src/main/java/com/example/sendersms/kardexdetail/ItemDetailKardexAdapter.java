package com.example.sendersms.kardexdetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;
import com.example.sendersms.kardex.KardexHolder;
import com.example.sendersms.product.ProductModel;

import java.util.List;

public class ItemDetailKardexAdapter extends RecyclerView.Adapter<ItemDetailKardexHolder> {
    List<ProductModel> list;

    public ItemDetailKardexAdapter(List<ProductModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemDetailKardexHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_kardex_row, parent, false);
        return new ItemDetailKardexHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDetailKardexHolder holder, int position) {
        final ProductModel productModel = list.get(position);
        holder.txvName.setText(productModel.getName());
        holder.txvQuantity.setText(productModel.getQuantity()+"");
        holder.txvPrice.setText(productModel.getPrice()+"");
        double subtotal = productModel.getPrice() * productModel.getQuantity();
        holder.txvSubtotal.setText(String.valueOf(subtotal));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItemDetail(ProductModel objProduct){
        list.add(objProduct);
        notifyDataSetChanged();
    }
}
