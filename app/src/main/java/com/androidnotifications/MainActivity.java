package com.androidnotifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });

    }

    public void createNotification() {
        Intent intent = new Intent(this, NotificationView.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        Notification notification = new Notification.Builder(this).setContentTitle("new mail from" + "test@gmail.com")
                .setContentText("Subject").setSmallIcon(R.mipmap.ic_launcher).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, notification);

    }

//    private void Notify(String notificationTitle) {
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        @SuppressWarnings("deprecation")
//
//        Notification notification = new Notification(R.mipmap.ic_launcher, "pesan baru", System.currentTimeMillis());
//        Intent notificationIntent = new Intent(this, NotificationView.class);
//        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, notificationIntent, 0);
//
//        notification.setLatestEventInfo(MainActivity.this, notificationTitle, notificationMessage, pendingIntent);
//        notificationManager.notify(9999, notification);
//    }

}
