import Player.Player;

import java.util.Random;

public class RandomArrangers {

    public static Player[] arrangeTurns(Player player1, Player player2){
        double number = new Random().nextDouble();
        if(number > 0.5){
            return new Player[]{player1, player2};
        }
        return new Player[]{player2, player1};
    }

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
