package com.example.lab42;

import java.io.Serializable;

public class Price implements Serializable {
    String company, price;

    public Price(String company, String price) {
        this.company = company;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getPrice() {
        return price;
    }
}
