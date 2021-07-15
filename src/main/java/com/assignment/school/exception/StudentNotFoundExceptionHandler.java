package com.assignment.school.exception;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentNotFoundExceptionHandler {
@ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity StudentNotFoundException(Exception e){
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}

}


