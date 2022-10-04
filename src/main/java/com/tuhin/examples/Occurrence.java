package com.tuhin.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Occurrence {

    public static int getMaxFreqDeviation(final String s) {
        final Map<Character, Integer> mapOfOccurrence = new HashMap<>();
        for (final char c : s.toCharArray()) {
            if (mapOfOccurrence.get(c) != null) {
                final int existingOccurrence = mapOfOccurrence.get(c);
                mapOfOccurrence.put(c, existingOccurrence + 1);
            } else {
                mapOfOccurrence.put(c, 1);
            }
        }
        final TreeSet<Integer> occurrences = new TreeSet<>(mapOfOccurrence.values());

        return occurrences.last() - occurrences.first();
    }

    public static void main(final String[] args) {
        System.out.println(getMaxFreqDeviation("bbacccabab"));
    }
}
