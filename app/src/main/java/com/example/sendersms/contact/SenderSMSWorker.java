package com.example.sendersms.contact;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.telephony.SmsManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.sendersms.helpers.NotificationBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SenderSMSWorker extends Worker {
    int SMS_CONTENT_LENGTH_LIMIT = 140;
    private int totalSended = 0;
    private int totalPhones = 0;
    List<ContactModel> listContact;
    SmsManager smsManager;
    // Intent Filter Tags for SMS SEND and DELIVER
    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";
    Context ctx;

    public SenderSMSWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ctx = context;
        smsManager = SmsManager.getDefault();
    }

    @NonNull
    @Override
    public Result doWork() {

        listContact = new ArrayList<>();
        final String[] arrayPhone = getInputData().getString("KEY_ARRAY_PHONE").split(",");
        final String[] arrayIds = getInputData().getString("KEY_ARRAY_IDS").split(",");
        final String message = getInputData().getString("KEY_MESSAGE");
        for(int j = 0 ; j < arrayPhone.length ; j++){
            ContactModel contact = new ContactModel();
            contact.setId(arrayIds[j]);
            contact.setNumberPhone(arrayPhone[j]);
            listContact.add(contact);
        }
        totalPhones = listContact.size();

        for(ContactModel contact : listContact){

            Log.d("WORKER_" , contact.getId());
            if(message.length() < SMS_CONTENT_LENGTH_LIMIT){
                PendingIntent sentPI = PendingIntent.getBroadcast(ctx, 0, new Intent(SENT), 0);
                ctx.registerReceiver(new SendReceiver(this, contact),new IntentFilter(SENT));
                PendingIntent deliveredPI = PendingIntent.getBroadcast(ctx, 0,new Intent(DELIVERED), 0);
                ctx.registerReceiver(new DeliverReceiver(),new IntentFilter(DELIVERED));
                smsManager.sendTextMessage(contact.getNumberPhone(), null, message, sentPI,deliveredPI);

            }else{

                ArrayList<String> strings = smsManager.divideMessage(message);
                ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
                ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();

                for (int i = 0; i < strings.size(); i++) {
                    PendingIntent sentPI = PendingIntent.getBroadcast(ctx, 0, new Intent(SENT), 0);
                    PendingIntent deliveredPI = PendingIntent.getBroadcast(ctx, 0,new Intent(DELIVERED), 0);
                    ctx.registerReceiver(new SendReceiver(this, contact),new IntentFilter(SENT));
                    ctx.registerReceiver(new DeliverReceiver(),new IntentFilter(DELIVERED));
                    sentPendingIntents.add(i, sentPI);
                    deliveredPendingIntents.add(i, deliveredPI);

                }
                smsManager.sendMultipartTextMessage(contact.getNumberPhone(), null, strings, sentPendingIntents, deliveredPendingIntents);

            }
        }
        return Result.success();
    }

    public int getTotalSended() {
        return totalSended;
    }

    public void setTotalSended(int totalSended) {
        this.totalSended = totalSended;
        NotificationBuilder.notificationProgress(
                ctx,
                "Campaña SMS",
                totalSended+"/"+totalPhones,
                totalSended,
                totalPhones
        );

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void calculateTotalSended(){
        final List<ContactModel> listSended = listContact.stream().filter(new Predicate<ContactModel>() {
            @Override
            public boolean test(ContactModel contactModel) {
                return contactModel.getSended();
            }
        }).collect(Collectors.<ContactModel>toList());
        setTotalSended(listSended.size());
    }

    //            Log.d("Changing->" , "(C) " + currentId + " -- " + "(N) " + newCurrentId);


}
