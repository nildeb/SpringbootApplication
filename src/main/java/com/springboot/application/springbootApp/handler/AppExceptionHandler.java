package com.springboot.application.springbootApp.handler;

import com.springboot.application.springbootApp.exception.InvalidRequestException;
import com.springboot.application.springbootApp.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppExceptionHandler {


    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String InvalidRequestHandler(InvalidRequestException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NoDataFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String recordNotFoundHandler(NoDataFoundException ex) {
        return ex.getMessage();
    }
}
