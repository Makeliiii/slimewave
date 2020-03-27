package com.example.lab23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // new arrayclass
        final ArrayClass arr = new ArrayClass();
        arr.addElements();

        // get the countries
        ArrayList<String> countries = arr.getCountries();

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
        final EditText text = new EditText(this);

        // create a list
        ListView list = new ListView(this);
        final ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
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

        // add onclick
        add.setOnClickListener(new View.OnClickListener() {
            final public void onClick(View view) {
                final String country = text.getText().toString();
                arr.addCountry(country);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        // delete onclick
        delete.setOnClickListener(new View.OnClickListener() {
            final public void onClick(View view) {
                final String country = text.getText().toString();
                arr.removeCountry(country);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        // set the content of the view
        setContentView(layout);
    }

    public static class ArrayClass {
        private ArrayList<String> countries = new ArrayList<String>();

        // add some countries
        public void addElements() {
            countries.add("Sweden");
            countries.add("Norway");
            countries.add("Japan");
            countries.add("Germany");
            countries.add("China");
            countries.add("Korea");
            countries.add("Denmark");
            countries.add("Italy");
        };

        // return all countries
        public ArrayList<String> getCountries() {
            return countries;
        };

        // add country
        public void addCountry(String country) {
            this.countries.add(country);
        };

        // remove country by index
        public void removeCountry(String country) {
            int index = this.countries.indexOf(country);
            this.countries.remove(index);
        };
    }
}
