package com.tuhin.examples.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FruitCrusher {
    public static void main(String[] args) {
        List<Integer> fruits = Arrays.asList(3, 3, 2, 2, 3);
//        List<Integer> fruits = Arrays.asList(3, 3, 2, 2, 1);
        LinkedList<Integer> linkedList = new LinkedList<>(fruits);
        int index = 0;
        for (; index < linkedList.size() - 1; ) {
            if (linkedList.getFirst() != linkedList.getLast()) {
                System.out.println("UnEqual");
                linkedList.pollFirst();
                linkedList.pollLast();
                System.out.println(linkedList);
                index=0;
            } else {
                System.out.println("Equal");
                linkedList.element();
                index++;
            }
        }
        System.out.println("Final" + linkedList);
    }
}
