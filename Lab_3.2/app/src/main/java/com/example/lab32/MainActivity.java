package com.example.lab32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMap(View view) {
        Uri location = Uri.parse("geo:64.9990505,25.511341?z=14");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void openCall(View view) {
        Uri call = Uri.parse("tel:+358206110200");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, call);
        startActivity(callIntent);
    }

    public void openSite(View view) {
        EditText getURL = (EditText) findViewById(R.id.text);
        String URL = getURL.getText().toString();

        if (TextUtils.isEmpty(URL)) {
            getURL.setError("URL can't be empty!");
            return;
        } else {
            Uri page = Uri.parse(URL);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, page);
            startActivity(webIntent);
        }

    }
}
