package com.tuhin.examples;

import java.util.Currency;

public class CurrentTest {
    public static void main(final String[] args) {
        final Currency currency = Currency.getInstance("EUR");
        System.out.println(currency);
    }
}
