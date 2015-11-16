package hu.kutya.sdk.exception;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import hu.kutya.sdk.exception.dto.FieldErrorResource;
import hu.kutya.sdk.exception.exception.InvalidRequestBodyException;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = StatusCodeAwareRuntimeException.class)
    @ResponseBody
    public ExceptionResponse handle(
            StatusCodeAwareRuntimeException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        response.setStatus(exception.getStatusCode());

        return new ExceptionResponse(exception);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            FieldErrorResource fieldErrorResource = new FieldErrorResource();
            fieldErrorResource.setResource(fieldError.getObjectName());
            fieldErrorResource.setField(fieldError.getField());
            fieldErrorResource.setCode(fieldError.getCode());
            fieldErrorResource.setMessage(fieldError.getDefaultMessage());
            fieldErrorResources.add(fieldErrorResource);
        }

        InvalidRequestBodyException e = new InvalidRequestBodyException(exception.getMessage());
        e.setPayload(fieldErrorResources);

        return new ExceptionResponse(e);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleHttpMessageNotReadable(
            HttpMessageNotReadableException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        InvalidRequestBodyException e = new InvalidRequestBodyException(exception.getMessage());

        return new ExceptionResponse(e);
    }



    @JsonPropertyOrder({"type", "status", "message"})
    public static class ExceptionResponse {

        @JsonProperty
        private Object payload;

        @JsonProperty
        private int status;

        @JsonProperty
        private String message;

        @JsonProperty
        private String type;

        public ExceptionResponse(StatusCodeAwareRuntimeException exception) {
            this.payload = exception.getPayload();
            this.status = exception.getStatusCode();
            this.message = exception.getMessage();
            this.type = exception.getClass().getSimpleName();
        }

        public ExceptionResponse() {
            this.status = 500;
            this.message = "KUTYA Internal Server Error";
            this.type = "UnhandledException";
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public String getType() {
            return type;
        }

        public Object getPayload() {
            return payload;
        }
    }
}
