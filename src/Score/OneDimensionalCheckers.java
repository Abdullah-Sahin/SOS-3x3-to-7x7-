package Score;

import Board.Board;

public class OneDimensionalCheckers {

    /**
     * Checks for given a point if a vertical SOS formed
     * @param board the object of class Board on which the gam eis being played
     * @param x the row coordinate of point
     * @param y the column coordinate of point
     * @return true if SOS formed
     */
    public static boolean verticalChecker(Board board, int x, int y){
        StringBuilder builder = new StringBuilder();
        for(int yCoor = y - 2; yCoor < y + 3; yCoor++){
            try{
                builder.append(board.getValueByCoordinates(x,yCoor));
            }
            catch (Exception e){
                builder.append("#");
            }
        }
        return builder.toString().contains("SOS");
    }
    /**
     * Checks for given a point if a horizontal SOS formed
     * @param board the object of class Board on which the gam eis being played
     * @param x the row coordinate of point
     * @param y the column coordinate of point
     * @return true if SOS formed
     */
    public static boolean horizontalChecker(Board board, int x, int y){
        StringBuilder builder = new StringBuilder();
        for(int xCoor = x - 2; xCoor < x + 3; xCoor++){
            try{
                builder.append(board.getValueByCoordinates(xCoor,y));
            }
            catch (Exception e){
                builder.append("#");
            }
        }
        return builder.toString().contains("SOS");
    }
    /**
     * Checks for given a point if a SOS formed from top left to bottom right
     * @param board the object of class Board on which the gam eis being played
     * @param x the row coordinate of point
     * @param y the column coordinate of point
     * @return true if SOS formed
     */
    public static boolean majorDiagonalChecker(Board board, int x, int y){
        StringBuilder builder = new StringBuilder();
        int xCoor = x-2;
        int yCoor = y-2;
        while(xCoor < x+3){
            try{
                builder.append(board.getValueByCoordinates(xCoor,yCoor));
            }
            catch (Exception e){
                builder.append("#");
            }
            xCoor++;
            yCoor++;
        }
        return builder.toString().contains("SOS");
    }
    /**
     * Checks for given a point if a SOS formed from top right to bottom left
     * @param board the object of class Board on which the gam eis being played
     * @param x the row coordinate of point
     * @param y the column coordinate of point
     * @return true if SOS formed
     */
    public static boolean minorDiagonalChecker(Board board, int x, int y){
        StringBuilder builder = new StringBuilder();
        int xCoor = x+2;
        int yCoor = y-2;
        while(xCoor > x-3){
            try{
                builder.append(board.getValueByCoordinates(xCoor,yCoor));
            }
            catch (Exception e){
                builder.append("#");
            }
            xCoor--;
            yCoor++;
        }
        return builder.toString().contains("SOS");
    }
}
