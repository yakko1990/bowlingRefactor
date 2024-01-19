package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ScoreTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public void normalScoreTest(  ) {
        String pins = "12345123451234512345";

        Game game = new Game(pins);
        assertEquals(60, game.getScore());

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
