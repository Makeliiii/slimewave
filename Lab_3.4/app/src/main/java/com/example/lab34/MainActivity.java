package com.example.lab34;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        final EditText text = findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = text.getText().toString();
                timerIntent(value);
            }
        });
    }

    public void timerIntent(String time) {
        Intent intent = new Intent(MainActivity.this, TimerActivity.class);
        intent.putExtra("eggTime", time);
        startActivity(intent);
    }
}
