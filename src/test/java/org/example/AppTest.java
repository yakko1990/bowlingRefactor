package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class AppTest extends TestCase {

    public void testNormalScore() {
        String pins = "12345123451234512345";

        Game game = new Game(pins);
        assertEquals(60, game.getScore());
    }

    public void testHeartBreakGame(){
        String pins = "9-9-9-9-9-9-9-9-9-9-";

        Game game = new Game(pins);
        assertEquals(90, game.getScore());
    }
    public void testPerfectGame(){

        String pins = "XXXXXXXXXXXX";

        Game game = new Game(pins);
        assertEquals(300, game.getScore());
    }

}
