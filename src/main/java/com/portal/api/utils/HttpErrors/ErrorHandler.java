package com.portal.api.utils.HttpErrors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerNotFound(MethodArgumentNotValidException exc) {

        var errors = exc.getFieldErrors();

        ErrorResponse error = new ErrorResponse("INVALID_PAYLOAD", "Invalid param on payload",
                errors.stream().map(ErrorObject::new).toList());

        return ResponseEntity.badRequest().body(error);

    }

}
