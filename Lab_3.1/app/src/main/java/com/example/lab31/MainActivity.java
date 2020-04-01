package com.example.lab31;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View view = (View) findViewById(R.id.view);
        TextView text = (TextView) findViewById(R.id.text);
        switch (item.getItemId()) {
            case R.id.red:
                text.setText("Red");
                view.setBackgroundColor(Color.parseColor("red"));
                return true;
            case R.id.green:
                text.setText("Green");
                view.setBackgroundColor(Color.parseColor("green"));
                return true;
            case R.id.blue:
                text.setText("Blue");
                view.setBackgroundColor(Color.parseColor("blue"));
                return true;
            case R.id.yellow:
                text.setText("Yellow");
                view.setBackgroundColor(Color.parseColor("yellow"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
