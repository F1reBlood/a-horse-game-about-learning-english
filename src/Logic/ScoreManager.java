package Logic;

public class MemoScore {
    private int score = 100;

    public void removeScore(int nbToRemove){
        score -= nbToRemove;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
