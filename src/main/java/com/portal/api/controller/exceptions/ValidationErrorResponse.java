package com.portal.api.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<ErrorObject> errors = new ArrayList<>();

    public List<ErrorObject> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorObject> errors) {
        this.errors = errors;
    }
}
