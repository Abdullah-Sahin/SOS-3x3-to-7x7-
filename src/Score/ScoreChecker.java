package Score;

import Board.Board;

public class ScoreChecker {


    /**
     * Checks for given a point if SOS formed from any dimension
     * @param board the object of class Board on which the gam eis being played
     * @param x the row coordinate of point
     * @param y the column coordinate of point
     * @return true if SOS formed
     */
    public static boolean SOSFormed(Board board, int x, int y){
        return OneDimensionalCheckers.horizontalChecker(board, x, y)
                || OneDimensionalCheckers.verticalChecker(board, x, y)
                || OneDimensionalCheckers.majorDiagonalChecker(board, x, y)
                || OneDimensionalCheckers.minorDiagonalChecker(board, x, y);
    }

}
