import Board.Board;
import Exceptions.InvalidDimensionException;
import Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Board board = null;
        boolean boardFormed = false;
        do{
            System.out.print("Please enter an integer at the interval [3,7] : ");
            try{
                int boardSize = Integer.parseInt(scanner.next());
                board = new Board(boardSize);
                boardFormed = true;
            }
            catch (InvalidDimensionException e){
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException | InputMismatchException e){
                System.out.println("Please type a valid integer");
            }
        }while(!boardFormed);

        System.out.print("Please enter your name: ");
        String playerName = scanner.next();
        Player player = new Player(playerName);

        new Game(player, board).start();

    }

}