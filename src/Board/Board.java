package Board;

import Exceptions.InvalidDimensionException;

import java.util.ArrayList;
import java.util.List;

/**
 * The board on which the players make actions
 */
public class Board {

    private final int size;
    private final String[][] valuesByCoordinates;
    private final List<String> availableCoordinates;

    /**
     * Constructor of objects of class Board
     * @param size each size of square board
     */
    public Board(int size){
        // If dimension is not valid throw error
        if(size < 3 || size > 7){
            throw new InvalidDimensionException(size);
        }
        this.size = size;
        this.valuesByCoordinates = new String[size][size];
        this.availableCoordinates = new ArrayList<>();
        for(int rowCoordinate = 0; rowCoordinate < size; rowCoordinate++){
            for(int columnCoordinate = 0; columnCoordinate < size; columnCoordinate++){
                valuesByCoordinates[rowCoordinate][columnCoordinate] = "-";
                availableCoordinates.add(rowCoordinate + "," + columnCoordinate);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String getValueByCoordinates(int rowCoordinate, int columnCoordinate) {
        return valuesByCoordinates[rowCoordinate][columnCoordinate];
    }

    public void setValueByCoordinates(String marker, int rowCoordinate, int columnCoordinate){
        valuesByCoordinates[rowCoordinate][columnCoordinate] = marker;
    }

    public List<String> getAvailableCoordinates() {
        return availableCoordinates;
    }
}
