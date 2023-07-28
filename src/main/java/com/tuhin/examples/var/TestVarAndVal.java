package com.tuhin.examples.var;

import lombok.val;

import java.util.List;

public class TestVarAndVal {
    public static void main(String[] args) {
        String str = "";
        val stores = List.of(str.split(","));
        System.out.println("stores " + stores + ", size " + stores.size());
        if (stores.size() <= 0) {
            System.err.println("ProcessController : store is 0");
        }
    }
}
