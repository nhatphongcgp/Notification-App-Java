package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.d("mytask","Fetching FCM registration token failed");
                        return;
                    }
                    // Get new FCM registration token
                    String token = task.getResult();
                    Log.d("mytask", token);
                    // create a varible get database
                    // implemnet fiel token to database before push
                    Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}