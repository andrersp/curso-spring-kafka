package com.portal.api.controller.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final String errorName;
    private final int errorCode;
    private final String errorDescription;
    private final List<ErrorObject> errors;
}
