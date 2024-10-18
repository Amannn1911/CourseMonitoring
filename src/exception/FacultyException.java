package exception;

public class FacultyException extends RuntimeException{
    public FacultyException() {
    }

    public FacultyException(String message) {
        super(message);
    }
}