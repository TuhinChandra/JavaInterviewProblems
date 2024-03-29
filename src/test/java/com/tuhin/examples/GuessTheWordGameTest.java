package com.tuhin.examples;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessTheWordGameTest {

    @Test
    public void userShouldWinOnce() {

        final String userInput = String.format("B%so%sK%sz%sy%sx%sv%su",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        final ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        GuessTheWordGame.main(new String[]{"3"});

        final String[] lines = baos.toString().split(System.lineSeparator());

        assertTrue(Arrays.asList(lines).contains("You wave won!!!"));
        assertTrue(Arrays.asList(lines).contains("Game Over!!!"));
    }

    @Test
    public void userShouldNotWinAnytime() {

        final String userInput = String.format("d%sa%sg%sz%sy",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        final ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        GuessTheWordGame.main(new String[]{"3"});

        final String[] lines = baos.toString().split(System.lineSeparator());

        assertFalse(Arrays.asList(lines).contains("You wave won!!!"));
        assertTrue(Arrays.asList(lines).contains("Game Over!!!"));
    }

}
