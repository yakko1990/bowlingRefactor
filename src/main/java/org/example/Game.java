package org.example;

public class Game {
    private String rolls;
    private int strikeValue = 10;
    private int spareValue = 10;
    public Game(){
        this.rolls = "";
    }
    public Game(String rolls){
        this.rolls = rolls.replace('-','0');
    }

    public int getScore(){
        char[] rolls = this.rolls.toCharArray();
        int score = 0;

        int turn = 0; // pueden variar entre 12 y 21
        int frame = 0; // 19 como maximo

        while(frame < 18) {
            if(rolls[turn] == '/'){
                    score = spareBonus(rolls, turn, score);
                    frame++;
            }else if(rolls[turn] == 'X') {
                    score = strikeBonus(rolls, turn, score);
                    frame+=2;
            }else{
                    score += pinsToNumber(rolls[turn]);
                    frame++;
            }
            turn++;
        }

        score = lastFrame(rolls, turn, score);

        return score;
    }

    private int pinsToNumber(char roll){
        return Character.getNumericValue(roll);
    }

    private int spareBonus(char[] rolls, int currentTurn, int score){
        score -= pinsToNumber(rolls[currentTurn - 1]);
        score += spareValue + pinsToNumber(rolls[currentTurn + 1]);
        return score;
    }
    private int strikeBonus(char[] rolls, int currentTurn, int score){
        char nextBall1 = rolls[currentTurn+1];
        char nextBall2 = rolls[currentTurn+2];

        if(nextBall1 =='X' && nextBall2 =='X'){
            score += strikeValue*3;
        } else if (nextBall1 == 'X') {
            score += strikeValue*2 + pinsToNumber(nextBall2);
        } else if (nextBall2 == '/'){
            score += strikeValue + spareValue;
        } else{
            score += strikeValue + pinsToNumber(nextBall1) + pinsToNumber(nextBall2);
        }
        return score;
    }
    private int lastFrame(char[] rolls, int currentTurn, int score){
        char ball1 = rolls[currentTurn];
        char ball2 = rolls[currentTurn+1];

        if (ball1 == 'X') {
            score = strikeBonus(rolls, currentTurn, score);
        } else if (ball2 =='/') {
            score+=pinsToNumber(ball1);
            score = spareBonus(rolls, currentTurn+1, score);
        }else{
            score += pinsToNumber(ball1) + pinsToNumber(ball2);
        }
        return score;
    }
}



