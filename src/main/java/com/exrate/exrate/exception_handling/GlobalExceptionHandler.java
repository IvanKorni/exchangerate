package com.exrate.exrate.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectData> handlerException(
            NotFoundException exception) {
        IncorrectData IncorrectData = new IncorrectData();
        IncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(IncorrectData, HttpStatus.NOT_FOUND);
    }

}
