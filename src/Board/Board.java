package Board;

import Exceptions.InvalidDimensionException;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int size;
    private final String[][] valuesByCoordinates;
    private final List<String> availableCoordinates;

    public Board(int size){
        if(size < 3 || size > 7){
            throw new InvalidDimensionException(size);
        }
        this.size = size;
        this.valuesByCoordinates = new String[size][size];
        this.availableCoordinates = new ArrayList<>();
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                valuesByCoordinates[x][y] = "-";
                availableCoordinates.add(x + "," + y);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String getValueByCoordinates(int x, int y) {
        return valuesByCoordinates[x][y];
    }

    public void setValueByCoordinates(String marker, int x, int y){
        valuesByCoordinates[x][y] = marker;
    }

    public List<String> getAvailableCoordinates() {
        return availableCoordinates;
    }
}
