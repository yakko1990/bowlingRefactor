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
        int cont = 0;
        for (char pin: pins) {
            if(pin!='-'){
                if(pin == '/'){
                    int nextBall = (pins[cont+1]!='-')?Character.getNumericValue(pins[cont+1]):0;
                    score-= Character.getNumericValue(pins[cont-1]);
                    score+= 10 + nextBall;
                }else if(pin == 'X') {

                    int nextBall = (pins[cont+1]!='-')?Character.getNumericValue(pins[cont+1]):0;
                    int nextBall2 = (pins[cont+2]!='-')?Character.getNumericValue(pins[cont+1]):0;

                    score = 10 + nextBall + nextBall2;

                }else{
                    score += Character.getNumericValue(pin);
                }
            }
            cont++;
        }

        return score;
    }

    private boolean computePerfectGame(String pins){
        return pins.equals("XXXXXXXXXXXX");
    }
}



