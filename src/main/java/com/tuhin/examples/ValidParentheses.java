package com.tuhin.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
    public static boolean isValid(final String str) {
        final Map<Character, Character> parenthesesMapping = new HashMap<>();
        parenthesesMapping.put('(', ')');
        parenthesesMapping.put('{', '}');
        parenthesesMapping.put('[', ']');

        final Stack<Character> parentheses = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (parenthesesMapping.containsKey(c)) {
                parentheses.push(c);
            } else {
                if (parentheses.isEmpty()) {
                    return false;
                }
                final char target = parentheses.pop();
                if (!parenthesesMapping.containsKey(target) || parenthesesMapping.get(target) != c) {
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }

    public static void main(final String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()[]"));
    }
}