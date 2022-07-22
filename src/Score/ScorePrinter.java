package Score;

import Player.Player;

public class ScorePrinter {
    /**
     * writes the scores of players to console
     * @param player1 player
     * @param player2 player
     */
    public static void printScores(Player player1, Player player2){
        System.out.println("-----------------");
        System.out.println("New Scores");
        System.out.println(player1.getName() + " -> " + player1.getScore());
        System.out.println(player2.getName() + " -> " + player2.getScore());
        System.out.println("-----------------");
    }
}
