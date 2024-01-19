package com.tuhin.examples;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListReverser  {

    public static void main(String[] args) {
        // Example usage with a LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("Original LinkedList: " + linkedList);

        Collections.reverse(linkedList);

        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
