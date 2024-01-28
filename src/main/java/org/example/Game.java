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

        for (char roll:rolls) {
            if(frame < 10){
                if(roll == '/'){
                    score = spareBonus(rolls, turn, score);
                    frame++;
                }else if(roll == 'X') {
                    score = strikeBonus(rolls, turn, score);
                    frame++;
                }else{
                    score += pinsToNumber(roll);
                }
            }
            if (frame == 10) {
                score = lastFrame(rolls, turn, score);
                frame++;
            }
            turn++;
        }
        return score;
    }

    private int pinsToNumber(char roll){
        return Character.getNumericValue(roll);
    }

    private int spareBonus(char[] rolls, int currentTurn, int score){
        score -= pinsToNumber(rolls[currentTurn - 1]);
        score += 10 + pinsToNumber(rolls[currentTurn + 1]);
        return score;
    }
    private int strikeBonus(char[] rolls, int currentTurn, int score){
        char nextBall1 = rolls[currentTurn+1];
        char nextBall2 = rolls[currentTurn+2];

        if(nextBall1 =='X' && nextBall2 =='X'){
            score += 10 + 10 + 10;
        } else if (nextBall1 == 'X') {
            score += 10 + 10 + pinsToNumber(nextBall2);
        } else if (nextBall2 == '/'){
            score += 10 + 10;
        } else{
            score += 10 + pinsToNumber(nextBall1) + pinsToNumber(nextBall2);
        }
        return score;
    }
    private int lastFrame(char[] rolls, int currentTurn, int score){
        char ball1 = rolls[currentTurn];
        char ball2 = rolls[currentTurn+1];

        if (ball1 == 'X') {
            score = strikeBonus(rolls, currentTurn, score);
        } else if (ball2 =='/') {
            score = spareBonus(rolls, currentTurn, score);
        }else{
            score += pinsToNumber(ball1) + pinsToNumber(ball2);
        }
        return score;
    }
    private boolean computePerfectGame(String rolls){
        return rolls.equals("XXXXXXXXXXXX");
    }
}



