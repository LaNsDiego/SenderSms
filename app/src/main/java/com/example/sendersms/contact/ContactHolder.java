package com.example.sendersms.contact;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendersms.R;

public class ContactHolder extends RecyclerView.ViewHolder {

    public TextView txvPhoneNumber;
    public ContactHolder(@NonNull View itemView) {
        super(itemView);
        txvPhoneNumber = itemView.findViewById(R.id.txv_phone_number_contact);
    }
}
