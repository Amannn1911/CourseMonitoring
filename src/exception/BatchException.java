package exception;

public class BatchException extends RuntimeException{
    public BatchException(String message) {
        super(message);
    }

    public BatchException() {
    }
}
