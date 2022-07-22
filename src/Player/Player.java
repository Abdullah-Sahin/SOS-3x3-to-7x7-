package Player;

import Board.Board;
import Board.BoardPrinter;
import Exceptions.CoordinatesNotAvailableException;
import Exceptions.NoSuchCoordinateException;
import Score.ScoreChecker;

import java.util.Random;
import java.util.Scanner;

public class Player {

    private final String name;

    private final PLAYERTYPES playerType;
    private String marker;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.playerType = PLAYERTYPES.Player;
    }
    
    public Player(){
        this.playerType = PLAYERTYPES.Computer;
        this.name = "Computer";
        this.score = 0;
    }


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

    public void randomMark(Board board) throws InterruptedException {
        int listSize = board.getAvailableCoordinates().size();
        int index = new Random().nextInt(listSize);
        int x = Integer.parseInt(board.getAvailableCoordinates().get(index).split(",")[0]);
        int y = Integer.parseInt(board.getAvailableCoordinates().get(index).split(",")[1]);
        mark(board, x, y);
    }

    public static void askToMark(Player player, Board board) throws NoSuchCoordinateException, InterruptedException {
        if(board.getAvailableCoordinates().size() == 0){
            System.out.println("Game ended");
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

    public static int[] askForCoordinates(Board board) throws  NoSuchCoordinateException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type x coordinate: ");
        int x = scanner.nextInt();
        if(x < 0 || x > board.getSize() - 1){
            throw new NoSuchCoordinateException(x);
        }
        System.out.print("Please type y coordinate: ");
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
