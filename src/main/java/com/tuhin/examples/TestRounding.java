package com.tuhin.examples;

public class TestRounding {
    public static void main(final String[] args) {
        System.out.println(roundOffPrice(6.3200));
        System.out.println(roundOffPrice(8.3400));

        System.out.println(roundOffPrice(11.32));

        System.out.println(roundOffPrice(68.7400));
        System.out.println(roundOffPrice(68.7800));

        System.out.println(roundOffPrice(458.4000));
        System.out.println(roundOffPrice(458.8000));

        System.out.println(roundOffPrice(1832));
        System.out.println(roundOffPrice(1846));
    }

    public static double roundOffPrice(final double stdPrice) {
        double roundOffPrice = stdPrice;
        if (stdPrice >= 5.00 && stdPrice <= 49.99) {
            roundOffPrice = roundOffWithDecimal(stdPrice, 5.00);
        } else if (stdPrice >= 50.00 && stdPrice <= 99.99) {
            roundOffPrice = roundOffWithDecimal(stdPrice, 10.00);
        } else if (stdPrice >= 100.00 && stdPrice <= 999.99) {
            roundOffPrice = roundOffWithDecimal(stdPrice, -10.00);
        } else if (stdPrice >= 1000.00) {
            roundOffPrice = roundOffWithoutDecimal(stdPrice);
        }
        return roundOffPrice;
    }

    private static double roundOffWithoutDecimal(final double stdPrice) {
        final double roundOffPrice;
        int unitDigit = ((int) stdPrice) % 10;
        final int restDigits = ((int) stdPrice) / 10;
        if (unitDigit <= 2) {
            unitDigit = 0;
        } else if (unitDigit > 2 && unitDigit <= 7) {
            unitDigit = 5;
        } else {
            unitDigit = 9;
        }
        roundOffPrice = (restDigits * 10) + unitDigit;
        return roundOffPrice;
    }

    private static double roundOffWithDecimal(final double stdPrice, final double roundingFactor) {
        final double roundOffPrice;
        if (roundingFactor > 0.00) {
            roundOffPrice = Math.round(stdPrice * 100.0 / roundingFactor) * roundingFactor / 100.0;
        } else {
            roundOffPrice = Math.round(stdPrice);
        }
        return roundOffPrice;
    }
}
