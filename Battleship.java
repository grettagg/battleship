package Assignment2;

public class Battleship {
    private boolean battleshipSunk = false;
    private int size = 2;
    private int health = size;

    public Battleship(int size, int health) {
        this.size = size;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isBattleshipSunk() {
        return battleshipSunk;
    }

    public void setBattleshipSunk(boolean battleshipSunk) {
        this.battleshipSunk = battleshipSunk;
    }
}
