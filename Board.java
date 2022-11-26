package Assignment2;

import AvatarExample.Avatar;

import java.util.Random;

public class Board {
    private int rows;
    private int columns;

    private Square[][] gameSquare;

    //Constructor
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        gameSquare = new Square[rows][columns];
        populateBoard();
    }

    private void populateBoard() { //populate the board with Squares
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                gameSquare[i][j] = new Square(i, j);
            }
        }
        generateBattleships();
    }

    private void generateBattleships() { // place battleships on the board
        Random r = new Random();
        int shipsPlaced = 0;
        while (shipsPlaced < SmallBattleship.maxShipCount) { // place Small Battleships
            SmallBattleship ship = new SmallBattleship();
            int row = r.nextInt(rows); // choose a random row to place the Ship
            int column = r.nextInt(columns); // choose a random column to place the Ship
            if (!gameSquare[row][column].isHasShip()) {
                gameSquare[row][column].setShip(ship);
                gameSquare[row][column].setHasShip(true);
                shipsPlaced++;
            }
        }

        shipsPlaced = 0; // reset the number of Placed Ships
        while (shipsPlaced < MediumBattleship.maxShipCount) {
            MediumBattleship ship = new MediumBattleship();
            boolean horizontal = r.nextBoolean();
            int row = r.nextInt(rows);
            int column = r.nextInt(columns);
            //check the left or right square
            //checking left in this case, as I decided that ships will go to the left
            if (horizontal && column > 0 && !gameSquare[row][column].isHasShip() && !gameSquare[row][column - 1].isHasShip()) {
                gameSquare[row][column].setShip(ship);
                gameSquare[row][column].setHasShip(true);
                gameSquare[row][column - 1].setShip(ship);
                gameSquare[row][column - 1].setHasShip(true);
                shipsPlaced++;
            } else if (!horizontal && row > 0 && !gameSquare[row][column].isHasShip() && !gameSquare[row - 1][column].isHasShip()) {
                //check above or bellow squares - I decided to check below
                gameSquare[row][column].setShip(ship);
                gameSquare[row][column].setHasShip(true);
                gameSquare[row - 1][column].setShip(ship);
                gameSquare[row - 1][column].setHasShip(true);
                shipsPlaced++;
            }
        }
        shipsPlaced = 0;
        while (shipsPlaced < LargeBattleship.maxShipCount) { // place Large Battleships, same logic as with Medium Ships
            LargeBattleship ship = new LargeBattleship();
            boolean horizontal = r.nextBoolean();
            int row = r.nextInt(rows);
            int column = r.nextInt(columns);
            if (horizontal && column > 1 && !gameSquare[row][column].isHasShip() && !gameSquare[row][column - 1].isHasShip() && !gameSquare[row][column - 2].isHasShip()) {
                gameSquare[row][column].setShip(ship);
                gameSquare[row][column].setHasShip(true);
                gameSquare[row][column - 1].setShip(ship);
                gameSquare[row][column - 1].setHasShip(true);
                gameSquare[row][column - 2].setShip(ship);
                gameSquare[row][column - 2].setHasShip(true);
                shipsPlaced++;
            } else if (!horizontal && row > 1 && !gameSquare[row][column].isHasShip() && !gameSquare[row - 1][column].isHasShip() && !gameSquare[row - 2][column].isHasShip()) {
                gameSquare[row][column].setShip(ship);
                gameSquare[row][column].setHasShip(true);
                gameSquare[row - 1][column].setShip(ship);
                gameSquare[row - 1][column].setHasShip(true);
                gameSquare[row - 2][column].setShip(ship);
                gameSquare[row - 2][column].setHasShip(true);
                shipsPlaced++;
            }
        }
    }

    public Square[][] getGameSquare() {
        return gameSquare;
    }

    public void setGameSquare(Square[][] gameSquare) {
        this.gameSquare = gameSquare;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String square = gameSquare[i][j].toString();
                s += square;
            }
            s += "\n";
        }
        return s;
    }
}
