package com.tuhin.examples.sainsburys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessTest {

    @Test
    public void testRun() {
        assertEquals("5d", Chess.run("2B", 3, 2));
        assertEquals("8a", Chess.run("5h", 11, 25));
        assertEquals("INVALID_INPUT", Chess.run("5hd", 0, 25));
    }
}
