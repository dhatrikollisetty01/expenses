package com.ess.expenses.core.exceptions;

import org.springframework.http.HttpStatus;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CustomException extends RuntimeException {

    private HttpStatus httpStatusCode;

    public CustomException(String message, HttpStatus httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

}