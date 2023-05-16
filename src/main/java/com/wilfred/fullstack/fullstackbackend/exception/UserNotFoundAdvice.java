package com.wilfred.fullstack.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class UserNotFoundAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public HashMap<String, String> exceptionHandler(UserNotFoundException userNotFoundException) {
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", userNotFoundException.getMessage());
        return errorMap;
    }
}
