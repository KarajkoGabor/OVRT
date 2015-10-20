package hu.kutya.sdk.exception.exception;

import hu.kutya.sdk.exception.StatusCodeAwareRuntimeException;

public class InvalidRequestBodyException extends StatusCodeAwareRuntimeException {
    public InvalidRequestBodyException() {
        super();
    }

    public InvalidRequestBodyException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return STATUS_BAD_REQUEST;
    }
}
