package com.example.julio.energiainteligente.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.ui.SplashActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessaging extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification());
    }

    private void showNotification(RemoteMessage.Notification notification) {
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pedingIntent = PendingIntent.getActivity(this,
                0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setAutoCancel(true)
                .setContentIntent(pedingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 2000;
        vibrator.vibrate(milliseconds);

    }
}
