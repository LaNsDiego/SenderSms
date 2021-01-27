package com.example.sendersms;

import android.app.Application;

import com.example.sendersms.helpers.NotificationBuilder;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationBuilder.createNotificationChannel(this);
    }
}
