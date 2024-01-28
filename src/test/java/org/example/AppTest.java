package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
public class AppTest {

    @Test
    public void testNormalScore() {
        String pins = "12345123451234512345";

        Game game = new Game(pins);
        assertEquals(60, game.getScore());
    }
    @Test
    public void testHeartBreakGame(){
        String pins = "9-9-9-9-9-9-9-9-9-9-";

        Game game = new Game(pins);
        assertEquals(90, game.getScore());
    }
    @Test
    public void testSpareEveryFrameGame(){
        String pins = "5/5/5/5/5/5/5/5/5/5/5";

        Game game = new Game(pins);
        assertEquals(150, game.getScore());
    }
    @Test
    public void testWithStrikeGame(){
        String pins = "5-5-5-5-5-X5-5-5-5-";

        Game game = new Game(pins);
        assertEquals(60, game.getScore());
    }

    @Test
    public void testTwoStrikesInARowGame(){
        String pins = "5-5-5-5-5-XX5-5-5-";
        Game game = new Game(pins);
        assertEquals(80, game.getScore());
    }

    @Disabled
    public void testTwoStrikesThenSpareGame(){
        String pins = "5-5-5-5-5-XX5/5-5-";
        Game game = new Game(pins);
        assertEquals(100, game.getScore());
    }
    @Disabled
    public void testTwoStrikesOneSpareGame(){
        String pins = "5-5-5-5-5-XX5-5-5/5";
        Game game = new Game(pins);
        assertEquals(90, game.getScore());
    }
    @Disabled
    public void testComplexGame(){
        String pins = "XXX728/-9X7/9-XX8";
        Game game = new Game(pins);
        assertEquals(180, game.getScore());
    }
    @Test
    public void testPerfectGame(){

        String pins = "XXXXXXXXXXXX";

        Game game = new Game(pins);
        assertEquals(300, game.getScore());
    }

}
