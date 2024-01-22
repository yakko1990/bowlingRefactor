package org.example;

public class Game {
    private String pins;

    public Game(String pins){
        this.pins = pins;
    }

    public int getScore(){
        char[] pins = this.pins.toCharArray();
        int score = 0;
        for (char pin: pins) {

            score += Character.getNumericValue(pin);
        }

        return score;
    }
}



