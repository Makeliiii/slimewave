package com.example.lab42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue que = Volley.newRequestQueue(this);
        String domain = "https://financialmodelingprep.com/";
        String path = "/api/company/price";
        String companies = "/AAPL,GOOGL,FB,NOK";
        String datatype = "?datatype=json";

        final List<Price> priceList = new ArrayList<>();
        final ListView listView = findViewById(R.id.list);

        final String[][] matrix = {
                { "AAPL", "Apple" },
                { "GOOGL", "Alphabet (Google)" },
                { "FB", "Facebook" },
                { "NOK", "Nokia" }
        };

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, domain + path + companies + datatype, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Iterator<String> keys = response.keys();

                            while (keys.hasNext()) {
                                String keyValue = (String) keys.next();
                                String valueString = response.getString(keyValue);

                                JSONObject priceObj = new JSONObject(valueString);
                                String price = priceObj.getString("price");

                                Log.i("VALUE", "onResponse: " + keyValue);

                                for (int i = 0; i < matrix.length; i++) {
                                    if (matrix[i][0].equals(keyValue.trim())) {
                                        priceList.add(new Price(matrix[i][1] + ":", price + " USD"));
                                    }
                                }
                            }

                            Adapter adapter = new Adapter(MainActivity.this, R.layout.prices, priceList);
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });

        que.add(jsonObjectRequest);
    }
}
