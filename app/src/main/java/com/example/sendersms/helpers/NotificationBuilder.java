package com.example.sendersms.helpers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.sendersms.R;

public abstract  class NotificationBuilder {

    private static String CHANNEL_ID = "GLOBAL";
    public static void notificationProgress(Context ctx, String title, String content , int progress,int maxProgress){
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx, CHANNEL_ID);
        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_baseline_near_me_24)
                .setAutoCancel(false)
                .setOnlyAlertOnce(true)
                .setProgress(maxProgress,progress,false);
        Notification notification = builder.build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(ctx);
        notificationManager.notify(1,notification);
    }

    public static void createNotificationChannel(Context ctx) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ctx.getString(R.string.channel_name);
            String description = ctx.getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = ctx.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
