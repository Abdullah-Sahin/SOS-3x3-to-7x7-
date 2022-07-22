package Board;

public class BoardPrinter {

    /*
    public static void printBoard(Board board){
        System.out.println("--------------------------");
        for(int x = 0; x < board.getSize(); x++){
            for(int y = 0; y < board.getSize(); y++){
                System.out.print(board.getValueByCoordinates(x, y) + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

     */

    public static void printBoard(Board board){
        String[][] printable = new String[board.getSize()+1][board.getSize()+1];
        printable[0][0] = "#";
        for(int x = 1; x < printable.length; x++){
            printable[x][0] = String.valueOf(x-1);
        }
        for(int y = 1; y < printable.length; y++){
            printable[0][y] = String.valueOf(y - 1);
        }
        for(int x = 1; x < printable.length; x++){
            for(int y = 1; y < printable.length; y++){
                printable[x][y] = board.getValueByCoordinates(x-1, y-1);
            }
        }
        System.out.println("--------------------------");
        for (String[] row : printable) {
            for (int y = 0; y < printable.length; y++) {
                System.out.print(row[y] + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static void printAvailableCoordinates(Board board){
        System.out.println("--------------------------");
        System.out.println("Available Coordinates");
        for(int x = 0; x < board.getSize(); x++){
            for(int y = 0; y < board.getSize(); y++){
                if(!board.getValueByCoordinates(x, y).equals("-")){
                    System.out.print("FILLED\t");
                }
                else{
                    System.out.print("(" + x + ", " + y + ")\t");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
