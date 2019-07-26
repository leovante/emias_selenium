package com.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class DispUrlParser {
    String address;
    int cardNumber;

    public DispUrlParser(String address) {
        this.address = address;
    }

    public int getCardNumber() throws MalformedURLException {
        URL u = new URL(address);
        String[] segments = u.getPath().split("/");
        String idStr = segments[segments.length-1];
        this.cardNumber = Integer.parseInt(idStr);
        return cardNumber;
    }
}
