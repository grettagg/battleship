package Assignment2;

import java.util.Scanner;

public class Player {
    private Board board;
    private String name;
    private int score;


    //constructor
    public Player(String name, Board board) {
        this.name = name;
        this.board = board; //opponents board
    }

    public boolean takeTurn() {
        System.out.println("\n\n" + "The board you're targeting:\n"+ board); // toString is called by default, no need to write
        Scanner s = new Scanner(System.in);
        System.out.println(name + ", enter your guess: ");
        int rowTargeted = s.nextInt();
        int columnTargeted = s.nextInt();
        Square targetedSquare = board.getGameSquare()[rowTargeted][columnTargeted]; // create targetedSquare for the ease of use
        if (!targetedSquare.isHasBeenShot()) { // if the square has not yet been shot
            targetedSquare.setHasBeenShot(true); // if a player shoots their shot, the square shot status changes to true
            if (targetedSquare.isHasShip()) { // there is a ship on the targeted square
                // gets to shoot a square with a ship
                System.out.println(board);
                System.out.println(name + " hit a ship!");
                int shipHealth = targetedSquare.getShip().getHealth();
                shipHealth--;
                targetedSquare.getShip().setHealth(shipHealth);
                // Check the health of the ship. If it is less than 1 (so, 0), that means this ship's status will change to sunk.
                if (shipHealth < 1) {
                    targetedSquare.getShip().setBattleshipSunk(true);
                    score++;
                    for (int i = 0; i < board.getRows(); i++) {
                        for (int j = 0; j < board.getColumns(); j++) {
                            if (board.getGameSquare()[i][j].isHasShip() && !board.getGameSquare()[i][j].getShip().isBattleshipSunk()) {
                                return false; // returns false if any of the ships still hasn't sunk
                            }
                        }
                    }
                    System.out.println(board);
                    System.out.println(name + " shot the last ship!");
                    return true;
                }
            } else { // No ship in the square
                System.out.println(board);
                System.out.println("No ship here, " + name + " missed.");
                return false;
            }

        } else {
            // the square has been shot already
            System.out.println("This square has been fired at already. " + name + "'s guess is invalid, you lose your turn.");
            return false;
        }
        return false;
    }

    //getters
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
