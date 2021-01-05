package com.example.sendersms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import 	android.telephony.SmsManager;

public class FirstFragment extends Fragment {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 100;
    EditText edtPhoneNumber , edtMessage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        edtPhoneNumber = view.findViewById(R.id.edt_phone_number);
        edtMessage =  view.findViewById(R.id.edt_phone_number);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                smsSendMessage(edtPhoneNumber.getText().toString() , edtMessage.getText().toString());
            }
        });
        checkPermission();
    }


    protected void checkPermission() {


        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    public void smsSendMessage(String phoneNumber , String mensaje) {

        SmsManager
                .getDefault()
                .sendTextMessage(phoneNumber, null,
                        mensaje,
                        null, null);

//        if (smsIntent.resolveActivity(getContext().getPackageManager()) != null) {
//            startActivity(smsIntent);
//        } else {
//            Toast.makeText(getContext(), "Error al enviar mensaje", Toast.LENGTH_SHORT).show();
//        }
    }
}