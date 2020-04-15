package com.example.lab34;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final TextView time = findViewById(R.id.time);

        Intent intent = getIntent();
        String timeString = intent.getStringExtra("eggTime");
        int timeValue = Integer.parseInt(timeString) * 1000;

        new CountDownTimer(timeValue, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                long timeLeft = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                time.setText(String.valueOf(timeLeft));
            }

            @Override
            public void onFinish() {
                Uri notifUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                Ringtone notif = RingtoneManager.getRingtone(getApplicationContext(), notifUri);
                notif.play();
                finish();
            }
        }.start();
    }
}
