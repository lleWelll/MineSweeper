package Exceptions;

public class InvalidModeException extends RuntimeException {
    public InvalidModeException() {
        super("Invalid mode chosen");
    }

    public InvalidModeException(String message) {
        super(message);
    }
}
