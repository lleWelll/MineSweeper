package Exceptions;

public class InvalidSizeException extends RuntimeException {
    public InvalidSizeException() {
        super("Invalid size");
    }

    public InvalidSizeException(String message) {
        super(message);
    }
}
