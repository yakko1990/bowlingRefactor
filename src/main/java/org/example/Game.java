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
            if(pin!='-' && cont < 20){
                if(pin == '/'){
                    int nextBall = valueNextBall(pins, cont, 1);
                    score-= valuePreviousBall(pins, cont, 1);
                    score+= 10 + nextBall;

                }else if(pin == 'X') {

                    int nextBall = valueNextBall(pins, cont, 1);
                    int nextBall2 = valueNextBall(pins, cont, 2);

                    score += 10 + nextBall + nextBall2;

                }else{
                    score += pinToNumber(pin);
                }
            }
            cont++;
        }

        return score;
    }

    private int pinToNumber(char pin){
        return Character.getNumericValue(pin);
    }
    private int valueNextBall(char[] pins, int cont, int position){
        int valueNextBall = 0;

        if(pins[cont+position]=='X' || pins[cont+position]=='/'){
            valueNextBall = 10;
        }else if(pins[cont+position]=='-'){
            valueNextBall = 0;
        }else{
            valueNextBall = Character.getNumericValue(pins[cont+position]);
        }
        return valueNextBall;
    }

    private int valuePreviousBall(char[]pins, int cont, int position){
        return Character.getNumericValue(pins[cont-position]);
    }
    private boolean computePerfectGame(String pins){
        return pins.equals("XXXXXXXXXXXX");
    }
}



