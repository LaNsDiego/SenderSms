package com.example.sendersms.sell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;
import com.example.sendersms.product.ProductModel;

import java.util.List;

public class SellAdapter extends RecyclerView.Adapter<SellHolder> {


    List<ProductModel> listProduct;
    SellInterface.ItemListener listener;

    public SellAdapter(List<ProductModel> listProduct, SellInterface.ItemListener listener) {
        this.listProduct = listProduct;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_sbifri, parent, false);
        return new SellHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellHolder holder, int position) {
        final ProductModel objProduct = listProduct.get(position);
//        holder.btnAddProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onClickItem(objProduct);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
}
