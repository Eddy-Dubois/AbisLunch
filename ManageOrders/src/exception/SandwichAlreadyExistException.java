package exception;

public class SandwichAlreadyExistException extends Exception {
    public SandwichAlreadyExistException(String message) {
        super(message);
    }
}
