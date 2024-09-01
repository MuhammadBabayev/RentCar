package org.example.rentcar.exception;

public class BalanceException extends RuntimeException {
    String message;
    public BalanceException(String message) {
        super(message);
        this.message = message;
    }
}
