package com.example.lab21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = new Button(this);
        btn.setText("I'm a button and I have been pressed " + i + " times.");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                btn.setText("I'm a button and I have been pressed " + i + " times.");
            }
        });

        setContentView(btn);
    }
}
