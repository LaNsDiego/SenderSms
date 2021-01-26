package com.example.sendersms.contact;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.ArrayList;

public class SenderSMSWorker extends Worker {

    Context ctx;
    public SenderSMSWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ctx = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        final String phoneNumber = getInputData().getString("KEY_PHONE");
        final String message = getInputData().getString("KEY_MESSAGE");
        int SMS_CONTENT_LENGTH_LIMIT = 140;
        SmsManager smsManager = SmsManager.getDefault();
        // Intent Filter Tags for SMS SEND and DELIVER
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        if(message.length() < SMS_CONTENT_LENGTH_LIMIT){
            // STEP-1___
            // SEND PendingIntent
            PendingIntent sentPI = PendingIntent.getBroadcast(ctx, 0, new Intent(SENT), 0);
            ctx.registerReceiver(new SendReceiver(),new IntentFilter(SENT));
            PendingIntent deliveredPI = PendingIntent.getBroadcast(ctx, 0,new Intent(DELIVERED), 0);
            ctx.registerReceiver(new DeliverReceiver(),new IntentFilter(DELIVERED));
            smsManager.sendTextMessage(phoneNumber, null, message, sentPI,deliveredPI);
        }else{
            ArrayList<String> strings = smsManager.divideMessage(message);
            ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
            ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();


            for (int i = 0; i < strings.size(); i++) {
                PendingIntent sentPI = PendingIntent.getBroadcast(ctx, 0, new Intent(SENT), 0);
                PendingIntent deliveredPI = PendingIntent.getBroadcast(ctx, 0,new Intent(DELIVERED), 0);
                ctx.registerReceiver(new SendReceiver(),new IntentFilter(SENT));
                ctx.registerReceiver(new DeliverReceiver(),new IntentFilter(DELIVERED));
                sentPendingIntents.add(i, sentPI);
                deliveredPendingIntents.add(i, deliveredPI);

            }
            smsManager.sendMultipartTextMessage(phoneNumber, null, strings, sentPendingIntents, deliveredPendingIntents);
        }
        return Result.success();
    }
}
