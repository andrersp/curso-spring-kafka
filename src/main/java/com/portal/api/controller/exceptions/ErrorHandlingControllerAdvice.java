package com.portal.api.controller.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        // ValidationErrorResponse error = new ValidationErrorResponse();
        List<ErrorObject> erros = e.getConstraintViolations().stream()
                .map(error -> new ErrorObject(error.getPropertyPath().toString(), null, error.getMessage().toString()))
                .collect(Collectors.toList());

        return new ErrorResponse("INVALID_CONSTRAINT", 1,
                "invalid constraint", erros);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<ErrorObject> erros = getErrors(e);

        return new ErrorResponse("INVALID_PAYLOAD", 1,
                "invalid payload", erros);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorObject onHttpMessageNotReadableException(HttpMessageNotReadableException e) {

        return new ErrorObject(e.getLocalizedMessage(), "", "");

    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return (List<ErrorObject>) ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

}
