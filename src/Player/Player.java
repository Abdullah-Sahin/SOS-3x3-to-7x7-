package Player;

import Board.Board;
import Board.BoardPrinter;
import Exceptions.CoordinatesNotAvailableException;
import Exceptions.NoSuchCoordinateException;
import Score.ScoreChecker;

import java.util.Random;
import java.util.Scanner;

/**
 * The class which arranges player's options and moves
 */
public class Player {

    private final String name;

    private final PLAYERTYPES playerType;
    private String marker;
    private int score;

    /**
     * Creates a real player
     * @param name name of player
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.playerType = PLAYERTYPES.Player;
    }

    /**
     * Creates a CPU player
     */
    public Player(){
        this.playerType = PLAYERTYPES.Computer;
        this.name = "Computer";
        this.score = 0;
    }

    /**
     * marks given point on the board
     * @param board the object of class Board on which game is being played
     * @param x the row coordinate
     * @param y the column coordinate
     * @throws CoordinatesNotAvailableException if typed coordinates are full
     * @throws InterruptedException when thread runs
     */
    public void mark(Board board, int x, int y) throws CoordinatesNotAvailableException, InterruptedException{
        if(!board.getValueByCoordinates(x, y).equals("-")){
            throw new CoordinatesNotAvailableException(x, y);
        }
        System.out.println(this.name + " marked coordinate: (" + x + "," + y +")");
        board.setValueByCoordinates(this.marker, x, y);
        board.getAvailableCoordinates().remove(x + "," + y);
        Thread.sleep(1500);
        BoardPrinter.printBoard(board);
        if(ScoreChecker.SOSFormed(board, x, y)){
            this.score += 1;
            System.out.println(this.name + " scored. New score: " + this.score);
            askToMark(this, board);
        }
    }

    /**
     * CPU randomly marks an empty coordinate
     * @param board the object of class Board on which game is being played
     * @throws InterruptedException when thread runs
     */
    public void randomMark(Board board) throws InterruptedException {
        int listSize = board.getAvailableCoordinates().size();
        int index = new Random().nextInt(listSize);
        int x = Integer.parseInt(board.getAvailableCoordinates().get(index).split(",")[0]);
        int y = Integer.parseInt(board.getAvailableCoordinates().get(index).split(",")[1]);
        mark(board, x, y);
    }

    /**
     * Makes the typed player to mark
     * @param player the player to mark
     * @param board the object of class Board on which game is being played
     * @throws NoSuchCoordinateException if coordinates are outside of bounds
     * @throws InterruptedException when thread runs
     */
    public static void askToMark(Player player, Board board) throws NoSuchCoordinateException, InterruptedException {
        if(board.getAvailableCoordinates().size() == 0){
            return;
        }
        if(player.getPlayerType() == PLAYERTYPES.Computer){
            player.randomMark(board);
        }
        else{
            int[] coordinates = askForCoordinates(board);
            int x = coordinates[0];
            int y = coordinates[1];
            player.mark(board, x, y);
        }
    }

    /**
     * ask player to give row and column values
     * @param board the object of Class board on which game is being played
     * @return size 2 array of integers whose first input is row coordinate and the other is y coordinate
     * @throws NoSuchCoordinateException if coordinates are outside of bounds
     */
    public static int[] askForCoordinates(Board board) throws  NoSuchCoordinateException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type row coordinate: ");
        int x = scanner.nextInt();
        if(x < 0 || x > board.getSize() - 1){
            throw new NoSuchCoordinateException(x);
        }
        System.out.print("Please type column coordinate: ");
        int y = scanner.nextInt();
        if(y < 0 || y > board.getSize() - 1){
            throw new NoSuchCoordinateException(y);
        }
        return new int[]{x,y};
    }



    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public int getScore() {
        return score;
    }

    public PLAYERTYPES getPlayerType() {
        return playerType;
    }

}
