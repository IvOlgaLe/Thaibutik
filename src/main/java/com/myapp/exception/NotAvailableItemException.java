package com.myapp.exception;

public class NotAvailableItemException extends RuntimeException {
    public NotAvailableItemException(String message) {
        super(message);
    }
}