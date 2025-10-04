package Logic;

public class Player {
    public String horse;
    public int posX;
    public int posY;

    public Player(String horse) {
        this.horse = horse;
        this.posX = 0;
        this.posY = 0;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
