package com.tuhin.examples.creditcardvalidation;

import java.util.Arrays;

public class CardNumberValidation {

    public static void main(final String[] args) {
        System.out.println("111111111111111 = " + isValidCreditCardNumber("111111111111111"));//false
        System.out.println("5478965320147852 = " + isValidCreditCardNumber("5478965320147852"));//false
        System.out.println("4556737586899855 = " + isValidCreditCardNumber("4556737586899855"));//true
    }

    public static boolean isValidCreditCardNumber(String cardNumber) {
        int[] cardIntArray = cardNumber.chars().map(Character::getNumericValue)
                .toArray();

        for (int i = cardIntArray.length - 2; i >= 0; i -= 2) {
            int num = cardIntArray[i] * 2;
            cardIntArray[i] = (num > 9) ? num - 9 : num;
        }

        int sum = Arrays.stream(cardIntArray).sum();
        return sum % 10 == 0;
    }
}
