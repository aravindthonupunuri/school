package com.assignment.school.exception;

public class StudentNotFoundException extends RuntimeException {


    public StudentNotFoundException() {
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
