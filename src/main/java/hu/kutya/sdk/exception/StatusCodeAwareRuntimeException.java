package hu.kutya.sdk.exception;

import org.springframework.boot.logging.LogLevel;

public class StatusCodeAwareRuntimeException extends RuntimeException {
    public static final int STATUS_UNAUTHORIZED = 401;
    public static final int STATUS_FORBIDDEN = 403;
    public static final int STATUS_NOT_FOUND = 404;
    public static final int STATUS_CONFLICT = 409;
    public static final int STATUS_BAD_REQUEST = 400;

    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
    public static final int STATUS_SERVICE_UNAVAILABLE = 503;

    protected Object payload;

    public StatusCodeAwareRuntimeException() {
        super();
    }

    public StatusCodeAwareRuntimeException(String message) {
        super(message);
    }

    public StatusCodeAwareRuntimeException(Throwable cause) {
        super(cause);
    }

    public StatusCodeAwareRuntimeException(String message, Throwable cause) {
        super(message, cause);

        if (cause == this) {
            throw new IllegalArgumentException("The exception cannot be the cause of itself!", null);
        }
    }

    public LogLevel getLogLevel() {
        return LogLevel.ERROR;
    }

    public int getStatusCode() {
        return STATUS_INTERNAL_SERVER_ERROR;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
