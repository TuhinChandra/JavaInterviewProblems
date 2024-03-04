package com.tuhin.examples.capitalone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiplicationWithoutMuliplyingTest {
    @Test
    void testMultipltTwoNumbers() {
        Assertions.assertEquals(0, MultiplicationWithoutMuliplying.multiply(0, 0));
        Assertions.assertEquals(0, MultiplicationWithoutMuliplying.multiply(0, 4));
        Assertions.assertEquals(0, MultiplicationWithoutMuliplying.multiply(4, 0));
        Assertions.assertEquals(8, MultiplicationWithoutMuliplying.multiply(2, 4));
        Assertions.assertEquals(8, MultiplicationWithoutMuliplying.multiply(-2, -4));
        Assertions.assertEquals(-8, MultiplicationWithoutMuliplying.multiply(2, -4));
        Assertions.assertEquals(-8, MultiplicationWithoutMuliplying.multiply(-2, 4));
        Assertions.assertEquals(-48, MultiplicationWithoutMuliplying.multiply(-3, 16));
        Assertions.assertEquals(-3L * Long.MAX_VALUE, MultiplicationWithoutMuliplying.multiply(Long.MAX_VALUE, -3));
    }
}