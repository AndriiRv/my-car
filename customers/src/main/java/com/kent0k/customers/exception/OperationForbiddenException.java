package com.kent0k.customers.exception;

public class OperationForbiddenException extends RuntimeException {

    public OperationForbiddenException(String message) {
        super(message);
    }
}
