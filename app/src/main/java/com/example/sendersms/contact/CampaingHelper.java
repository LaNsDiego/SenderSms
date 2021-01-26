package com.example.sendersms.contact;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class CampaingHelper {


    public static void sendSMS(final Context ctx ,String phoneNumber, String message) {



// STEP-2___
        // SEND BroadcastReceiver


        // DELIVERY BroadcastReceiver

// STEP-3___
        // ---Notify when the SMS has been sent---
//        final IntentFilter intentFilter = new IntentFilter(SENT);
//        final Intent iS = new Intent(ctx,SendReceiver.class);
//        ctx.sendBroadcast(iS);
//        requireActivity().registerReceiver(sendSMS, new IntentFilter(SENT));

        // ---Notify when the SMS has been delivered---
//        final Intent iD = new Intent(ctx,DeliverReceiver.class);
//        ctx.sendBroadcast(iD);
//        requireActivity().registerReceiver(deliverSMS, new IntentFilter(DELIVERED));

        int SUB_ID = 0;

    }
}
