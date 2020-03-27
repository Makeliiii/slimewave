package com.example.lab24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get editText
        final EditText editText = (EditText) findViewById(R.id.editText);

        // get textView
        final TextView text = (TextView) findViewById(R.id.text);

        // get buttons
        Button english = (Button) findViewById(R.id.english);
        Button sverige = (Button) findViewById(R.id.sverige);
        Button suomeksi = (Button) findViewById(R.id.suomeksi);
        Button surprise = (Button) findViewById(R.id.surprise);

        english.setOnClickListener(new View.OnClickListener() {
            final public void onClick(View view) {
                final String name = editText.getText().toString();
                final String greeting = "Hello, " + name + "!";
                text.setText(greeting);
            }
        });

        sverige.setOnClickListener(new View.OnClickListener() {
            final public void onClick(View view) {
                final String name = editText.getText().toString();
                final String greeting = "Hejsan, " + name + "!";
                text.setText(greeting);
            }
        });

        suomeksi.setOnClickListener(new View.OnClickListener() {
            final public void onClick(View view) {
                final String name = editText.getText().toString();
                final String greeting = "Morjesta, " + name + "!";
                text.setText(greeting);
            }
        });

        surprise.setOnClickListener(new View.OnClickListener() {
            final public void onClick(View view) {
                final String name = editText.getText().toString();
                final String greeting = "No terve, " + name + "!";
                text.setText(greeting);
            }
        });
    }
}
