import Player.Player;

import java.util.Random;

public class RandomArrangers {
    /**
     * Given two players, forms a query for playing turns
     * @param player1 player
     * @param player2 player
     * @return an size 2 array of players whose first index contains the player to move first and second in the other
     */
    public static Player[] arrangeTurns(Player player1, Player player2){
        double number = new Random().nextDouble();
        if(number > 0.5){
            return new Player[]{player1, player2};
        }
        return new Player[]{player2, player1};
    }

    /**
     * Given two players, chooses who will mark S and who will mark O
     * @param player1 player
     * @param player2 player
     */
    public static void arrangeMarkers(Player player1, Player player2){
        double number = new Random().nextDouble();
        if(number > 0.5){
            player1.setMarker("S");
            player2.setMarker("O");
        }
        else{
            player1.setMarker("O");
            player2.setMarker("S");
        }
    }
}
