package hu.kutya.car.exception;

import hu.kutya.sdk.exception.StatusCodeAwareRuntimeException;

import org.springframework.boot.logging.LogLevel;

public class CarTemplateNotFoundException extends StatusCodeAwareRuntimeException {
    @Override
    public LogLevel getLogLevel() {
        return LogLevel.TRACE;
    }

    @Override
    public int getStatusCode() {
        return STATUS_NOT_FOUND;
    }
}
