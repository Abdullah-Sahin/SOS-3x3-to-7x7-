package Exceptions;

public class CoordinatesNotAvailableException extends RuntimeException{
    private final int x;
    private final int y;

    public CoordinatesNotAvailableException(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return "Coordinates (" + x + ", " + y + ") is not available";
    }
}
