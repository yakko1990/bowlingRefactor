package org.example;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testNormalScore() {
        String pins = "12345123451234512345";

        Game game = new Game(pins);
        assertEquals(60, game.getScore());
    }
}
