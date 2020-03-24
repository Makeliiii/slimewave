package com.example.lab22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] COUNTRIES = new String[] {
                "Sweden", "Norway", "Japan", "Germany", "China", "Korea", "Denmark", "Italy"
        };

        // create some layouts
        LinearLayout layout = new LinearLayout(this);
        LinearLayout btnLayout = new LinearLayout(this);

        // set some layout params
        layout.setOrientation(LinearLayout.VERTICAL);
        btnLayout.setGravity(Gravity.CENTER);

        // create some buttons
        Button add = new Button(this);
        Button edit = new Button(this);
        Button delete = new Button(this);

        // create a text editor
        EditText text = new EditText(this);

        // create a list
        ListView list = new ListView(this);
        final ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        list.setAdapter(arrayAdapter);

        // add some text to buttons
        add.setText("Add");
        edit.setText("Edit");
        delete.setText("Delete");

        // adding some views
        btnLayout.addView(add);
        btnLayout.addView(edit);
        btnLayout.addView(delete);
        layout.addView(btnLayout);
        layout.addView(text);
        layout.addView(list);

        // set the content of the view
        setContentView(layout);
    }
}
