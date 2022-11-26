package Assignment2;

import java.util.Scanner;

public class AE2 {

    public static void main(String[] args) {
        // Create Boards for Players
        Board playerOneBoard = new Board(10, 10);
        Board playerTwoBoard = new Board(10, 10);
        // Create Players
        Scanner s = new Scanner(System.in);
        System.out.println("1st Player, enter your name: "); // ask Player name
        String userNameOne = s.nextLine();
        Player playerOne = new Player(userNameOne, playerTwoBoard); // Create a player, each player attacks opponent's board
        System.out.println("2nd Player, enter your name: "); // ask Player name
        String userNameTwo = s.nextLine();
        Player playerTwo = new Player(userNameTwo, playerOneBoard);


        // main game loop
        while (true) { // Infinite loop, will run until we break out of it. We will only break out of it once one of the Players wins.
            if (!playerOne.takeTurn()) {
                if (playerTwo.takeTurn()) {
                    break;
                }
            } else {
                break;
            }
        }

        //Once we break out of the loop, check the scores.
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println(playerOne.getName() + " has won!");
        } else if (playerOne.getScore() < playerTwo.getScore()) {
            System.out.println(playerTwo.getName() + " has won!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
