package com.tuhin.examples;

public class StringReverser {

    public static String reverseStringUsingStringBuilder(String input) {
        if (input == null) {
            return null; // Handle null input if needed
        }
        return new StringBuilder(input).reverse().toString();
    }
    public static String reverseString(String input) {
        if (input == null) {
            return null; // Handle null input if needed
        }

        // Create a StringBuilder and append characters in reverse order
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }
    public static void main(String[] args) {
        // Example usage:
        String original = "Stream Reversal";
        System.out.println("Original: " + original);
        String reversed = reverseStringUsingStringBuilder(original);
        System.out.println("Reversed using StringBuilder: " + reversed);
        reversed = reverseString(original);
        System.out.println("Reversed using for loop: " + reversed);


    }
}

