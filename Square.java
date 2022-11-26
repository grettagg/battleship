package Assignment2;

public class Square {
    //attributes
    private int row;
    private int column;
    private boolean hasShip = false;
    private Battleship ship;
    private boolean hasBeenShot = false;

    //constructor
    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isHasShip() {
        return hasShip;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public Battleship getShip() {
        return ship;
    }

    public void setShip(Battleship ship) {
        this.ship = ship;
    }

    public boolean isHasBeenShot() {
        return hasBeenShot;
    }

    public void setHasBeenShot(boolean hasBeenShot) {
        this.hasBeenShot = hasBeenShot;
    }

    public String toString() {
        String display;
        if (!hasBeenShot) {
            String noInfo = "-";
            display = String.format("%3s", noInfo);
        } else if (!hasShip) {
            String shipHit = "o";
            display = String.format("%3s", shipHit);
        } else {
            String shipMissed = "x";
            display = String.format("%3s", shipMissed);
        }
        return display;
    }
}
