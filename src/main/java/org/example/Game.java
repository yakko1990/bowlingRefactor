package org.example;

public class Game {
    private String rolls;
    public Game(){
        this.rolls = "";
    }
    public Game(String rolls){
        this.rolls = rolls.replace('-','0');
    }

    public int getScore(){
        char[] rolls = this.rolls.toCharArray();
        int score = 0;

        if(computePerfectGame(this.rolls)){
            return 300;
        }
        int turn = 0;
        int frame = 10;
        for (char pin: rolls) {
            if(pin!='-' && turn < 20){
                if(pin == '/'){
                    int nextBall = valueNextBall(rolls, turn, 1);
                    score-= valuePreviousBall(rolls, turn, 1);
                    score+= 10 + nextBall;

                }else if(pin == 'X') {

                    int nextBall = valueNextBall(rolls, turn, 1);
                    int nextBall2 = valueNextBall(rolls, turn, 2);

                    if(nextBall < 10 && nextBall2 == 10){
                        score += 10 + nextBall2;
                    }else {
                        score += 10 + nextBall + nextBall2;
                    }

                }else{
                    score += pinToNumber(pin);
                }
            }
            turn++;
        }

        return score;
    }

    private int pinToNumber(char roll){
        return Character.getNumericValue(roll);
    }
    private int valueNextBall(char[] rolls, int currentTurn, int nexTurn){
        int valueNextBall = 0;

        if(rolls[currentTurn+nexTurn]=='X' || rolls[currentTurn+nexTurn]=='/'){
            valueNextBall = 10;
        }else if(rolls[currentTurn+nexTurn]=='-'){
            valueNextBall = 0;
        }else{
            valueNextBall = Character.getNumericValue(rolls[currentTurn+nexTurn]);
        }
        return valueNextBall;
    }

    private int valuePreviousBall(char[]rolls, int currentTurn, int previousTurn){
        return Character.getNumericValue(rolls[currentTurn-previousTurn]);
    }
    private boolean computePerfectGame(String rolls){
        return rolls.equals("XXXXXXXXXXXX");
    }
}



