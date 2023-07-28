package com.tuhin.examples.creditcardvalidation;

import java.util.Arrays;

public class CardNumberValidation {

    public static void main(final String[] args) {
        System.out.println(validCreditCardNumberAgainstLuhnAlgo("111111111111111"));
    }

    public static boolean validCreditCardNumberAgainstLuhnAlgo(final String cardNumber) {
        boolean isValidCardNumber = false;
        final int[] cardIntArray = new int[cardNumber.length()];

        for (int i = 0; i < cardNumber.length(); i++) {
            final char c = cardNumber.charAt(i);
            cardIntArray[i] = Integer.parseInt("" + c);
        }

        for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
            int num = cardIntArray[i];
            num = num * 2;
            if (num > 9) {
                num = num % 10 + num / 10;
            }
            cardIntArray[i] = num;
        }

        final int sum = sumDigits(cardIntArray);

        if (sum % 10 == 0) {
            isValidCardNumber = true;
        }

        return isValidCardNumber;

    }

    public static int sumDigits(final int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
