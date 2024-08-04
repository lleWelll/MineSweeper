package Exceptions;

public class InvalidAmountOfBombsException extends RuntimeException {
    public InvalidAmountOfBombsException() {
        super("Invalid amount of bombs");
    }

    public InvalidAmountOfBombsException(String message) {
        super(message);
    }
}
