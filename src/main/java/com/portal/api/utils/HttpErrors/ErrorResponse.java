package com.portal.api.utils.HttpErrors;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String errorName;
    private String errorDescription;
    private List<ErrorObject> errors;

}
