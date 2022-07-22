package Exceptions;

public class NoSuchCoordinateException extends RuntimeException{

    private final int entry;

    public NoSuchCoordinateException(int entry){
        this.entry = entry;
    }

    @Override
    public String getMessage() {
        return "No such coordinate exists in the board. Entry: " + entry;
    }
}
