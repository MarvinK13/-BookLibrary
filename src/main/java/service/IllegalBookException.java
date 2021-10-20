package service;

public class IllegalBookException extends RuntimeException {
    public IllegalBookException(String message) {
        super(message);
    }
}