package com.portal.api.utils.HttpErrors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {

        var errors = exc.getFieldErrors();

        ErrorResponse error = new ErrorResponse("INVALID_PAYLOAD", "Invalid param on payload",
                errors.stream().map(ErrorObject::new).toList());

        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse hanlderInternalError() {

        ErrorResponse error = new ErrorResponse("INTERNAL_ERROR",
                "Internal eror",
                null);

        return error;
    }

}
