package Exceptions;

public class InvalidDimensionException extends RuntimeException{

    private final int entry;

    public InvalidDimensionException(int entry){
        this.entry = entry;
    }

    @Override
    public String getMessage() {
        return "Dimension must be in the interval [3,7]. Entry: " + entry;
    }
}
