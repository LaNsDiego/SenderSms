package com.example.sendersms.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

    List<ContactModel> listKardex;

    public ContactAdapter(List<ContactModel> listKardex) {
        this.listKardex = listKardex;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listKardex.size();
    }
}
