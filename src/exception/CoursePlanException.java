package exception;

public class CoursePlanException extends RuntimeException{
    public CoursePlanException(String message) {
        super(message);
    }

    public CoursePlanException() {
    }
}