package Logic;

public class ScoreManager {
    private int score = 0;

    public void removeScore(int nbToRemove){
        score -= nbToRemove;
    }

    public void addScore(int nbToAdd){
        score += nbToAdd;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
