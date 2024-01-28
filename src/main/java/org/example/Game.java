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
        int turn = 0; // pueden variar entre 12 y 21
        int frame = 0; // 10 como maximo

        for (char roll: rolls) {
            if(turn < 20){
                if(roll == '/'){
                    score = spareBonus(rolls, turn, score);
                }else if(roll == 'X') {

                    int nextBall = valueNextBall(rolls, turn, 1);
                    int nextBall2 = valueNextBall(rolls, turn, 2);

                    if(nextBall < 10 && nextBall2 == 10){
                        score += 10 + nextBall2;
                    }else {
                        score += 10 + nextBall + nextBall2;
                    }

                }else{
                    score += pinToNumber(roll);
                }
            }
            turn++;
        }

        return score;
    }

    private int pinToNumber(char roll){
        return Character.getNumericValue(roll);
    }

    private int spareBonus(char rolls[], int currentTurn, int score){
        score -= Character.getNumericValue(rolls[currentTurn - 1]);
        score+= 10 + Character.getNumericValue(rolls[currentTurn + 1]);
        return score;
    }
    private int valueNextBall(char[] rolls, int currentTurn, int nexTurn){
        int valueNextBall = 0;

        if(rolls[currentTurn+nexTurn]=='X' || rolls[currentTurn+nexTurn]=='/'){
            valueNextBall = 10;
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



