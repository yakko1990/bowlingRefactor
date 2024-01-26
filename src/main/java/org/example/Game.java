package org.example;

public class Game {
    private String pins;


    public Game(){
        this.pins = "";
    }
   public Game(String pins){
        this.pins = pins;
    }

    public int getScore(){
        char[] pins = this.pins.toCharArray();
        int score = 0;
        if(computePerfectGame(this.pins)){
            return 300;
        }
        for (char pin: pins) {
            if(pin!='-'){
                score += Character.getNumericValue(pin);
            }
        }
        return score;
    }

    private boolean computePerfectGame(String pins){
        return pins.equals("XXXXXXXXXXXX");
    }
}



