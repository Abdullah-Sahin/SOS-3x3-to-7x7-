import Board.Board;
import Board.BoardPrinter;
import Player.Player;
import Score.ScorePrinter;

import java.util.InputMismatchException;

public class Game {

    private final Player player1;
    private final Player player2;
    private final Board board;
    public Game(Player player1, Board board) {
        this.player1 = player1;
        this.player2 = new Player();
        this.board = board;
    }

    public void start() throws InterruptedException {
        Player[] byTurn = RandomArrangers.arrangeTurns(player1, player2);
        Player firstPlayer = byTurn[0];
        Player secondPlayer = byTurn[1];
        RandomArrangers.arrangeMarkers(player1, player2);

        System.out.println("First player: " + firstPlayer.getName());
        System.out.println("Second Player: " + secondPlayer.getName());
        System.out.println(firstPlayer.getName() + " -> " + firstPlayer.getMarker());
        System.out.println(secondPlayer.getName() + " -> " + secondPlayer.getMarker());

        Thread.sleep(2000);

        BoardPrinter.printBoard(board);

        while(board.getAvailableCoordinates().size() > 0){

            boolean firstPlayerMarked = false;
            while(!firstPlayerMarked){
                if(board.getAvailableCoordinates().size() == 0){
                    break;
                }
                System.out.println(firstPlayer.getName() + "'s Turn");
                try{
                    Player.askToMark(firstPlayer, board);
                    firstPlayerMarked = true;
                }
                catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Please type an integer");
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            ScorePrinter.printScores(firstPlayer, secondPlayer);

            boolean secondPlayerMarked = false;
            while(!secondPlayerMarked){
                if(board.getAvailableCoordinates().size() == 0){
                    break;
                }
                System.out.println(secondPlayer.getName() + "'s Turn");
                try{
                    Player.askToMark(secondPlayer, board);
                    secondPlayerMarked = true;
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        if(firstPlayer.getScore() > secondPlayer.getScore()){
            System.out.println(firstPlayer.getName() + " won the game. Scores: " + firstPlayer.getScore() + "-" + secondPlayer.getScore());
        }
        if(secondPlayer.getScore() > firstPlayer.getScore()){
            System.out.println(secondPlayer.getName() + " won the game. Scores: " + secondPlayer.getScore() + "-" + firstPlayer.getScore());
        }
        else{
            System.out.println("Draw. Scores: " + firstPlayer.getScore() + "-" + secondPlayer.getScore());
        }


    }


}
