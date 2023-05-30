package com.portal.api.utils.HttpErrors;

import org.springframework.validation.FieldError;

public record ErrorObject(String field, String message) {
    public ErrorObject(FieldError erro) {
        this(erro.getField(), erro.getDefaultMessage());

    }

}
