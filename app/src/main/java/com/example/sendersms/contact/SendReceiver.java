package com.example.sendersms.contact;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class SendReceiver extends BroadcastReceiver {

    private ContactModel contact;
    SenderSMSWorker senderSMSWorker;
    public SendReceiver(SenderSMSWorker senderSMSWorker, ContactModel contact) {
        this.contact = contact;
        this.senderSMSWorker = senderSMSWorker;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onReceive(Context ctx, Intent intent) {

        switch (getResultCode()) {
            case Activity.RESULT_OK:
//                senderSMSWorker.setCurrentId(currentId);
                contact.setSended(true);
                senderSMSWorker.calculateTotalSended();
                Toast.makeText(ctx, "SMS sent",
                        Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                Toast.makeText(ctx, "Generic failure",
                        Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_NO_SERVICE:
                Toast.makeText(ctx, "No service",
                        Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_NULL_PDU:
                Toast.makeText(ctx, "Null PDU",
                        Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_RADIO_OFF:
                Toast.makeText(ctx, "Radio off",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
