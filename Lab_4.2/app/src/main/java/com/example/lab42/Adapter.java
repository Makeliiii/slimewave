package com.example.lab42;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Price> {
    List<Price> priceList;
    Context context;
    int resource;

    public Adapter(Context context, int resource, List<Price> priceList) {
        super(context, resource, priceList);
        this.context = context;
        this.resource = resource;
        this.priceList = priceList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        TextView companyText = view.findViewById(R.id.company);
        TextView priceText = view.findViewById(R.id.price);

        Price price = priceList.get(position);

        companyText.setText(price.getCompany());
        priceText.setText(price.getPrice());

        return view;
    }
}
