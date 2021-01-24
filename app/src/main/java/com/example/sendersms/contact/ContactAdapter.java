package com.example.sendersms.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

    List<ContactModel> listContact;

    public ContactAdapter(List<ContactModel> listContact) {
        this.listContact = listContact;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        final ContactModel contactModel = listContact.get(position);
        holder.txvPhoneNumber.setText(contactModel.getNumberPhone());
    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }
}
