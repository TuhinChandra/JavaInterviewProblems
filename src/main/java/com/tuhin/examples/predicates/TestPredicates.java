package com.tuhin.examples.predicates;

import java.util.function.Predicate;

public class TestPredicates {
    public static void main(final String[] args) {
       
        final Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));
    }
}
