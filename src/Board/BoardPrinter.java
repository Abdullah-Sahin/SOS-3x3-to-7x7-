package Board;

public class BoardPrinter {

    /**
     * Prints coordinates and values inside a given board
     */
    public static void printBoard(Board board){
        String[][] printable = new String[board.getSize()+1][board.getSize()+1];
        printable[0][0] = "#";
        for(int rowCoordinate = 1; rowCoordinate < printable.length; rowCoordinate++){
            printable[rowCoordinate][0] = String.valueOf(rowCoordinate-1);
        }
        for(int columnCoordinate = 1; columnCoordinate < printable.length; columnCoordinate++){
            printable[0][columnCoordinate] = String.valueOf(columnCoordinate - 1);
        }
        for(int rowCoordinate = 1; rowCoordinate < printable.length; rowCoordinate++){
            for(int columnCoordinate = 1; columnCoordinate < printable.length; columnCoordinate++){
                printable[rowCoordinate][columnCoordinate] = board.getValueByCoordinates(rowCoordinate-1, columnCoordinate-1);
            }
        }
        System.out.println("--------------------------");
        for (String[] row : printable) {
            for (int columnCorrdinate = 0; columnCorrdinate < printable.length; columnCorrdinate++) {
                System.out.print(row[columnCorrdinate] + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

}
