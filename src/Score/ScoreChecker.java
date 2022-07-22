package Score;

import Board.Board;

public class ScoreChecker {



    public static boolean SOSFormed(Board board, int x, int y){
        return OneDimensionalCheckers.horizontalChecker(board, x, y)
                || OneDimensionalCheckers.verticalChecker(board, x, y)
                || OneDimensionalCheckers.majorDiagonalChecker(board, x, y)
                || OneDimensionalCheckers.minorDiagonalChecker(board, x, y);
    }

}
