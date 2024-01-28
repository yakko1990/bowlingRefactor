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
                    score = strikeBonus(rolls, turn, score);
                }else{
                    score += pinsToNumber(roll);
                }
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
    private int strikeBonus(char[] rolls, int currentTurn, int score ){
        char nextball1 = rolls[currentTurn+1];
        char nextball2 = rolls[currentTurn+2];
        char nextball3 = rolls[currentTurn+3];

        if(nextball3 == '/'){
            score += 10 + 10 + 10;
        } else if (nextball1 =='X' && nextball2 !='X') {
            score += 10 + 10 + pinsToNumber(nextball2);
        }else {
            score+= 10 + 10 + 10;
        }
        return score;
    }
    private boolean computePerfectGame(String rolls){
        return rolls.equals("XXXXXXXXXXXX");
    }
}



