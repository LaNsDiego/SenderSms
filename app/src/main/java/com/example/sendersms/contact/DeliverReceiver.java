package com.example.sendersms.contact;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DeliverReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context ctx, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Log.e("DELIVER", key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
            }
        }
        switch (getResultCode()) {
            case Activity.RESULT_OK:
                Toast.makeText(ctx, "SMS delivered",
                        Toast.LENGTH_SHORT).show();
                break;
            case Activity.RESULT_CANCELED:
                Toast.makeText(ctx, "SMS not delivered",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
