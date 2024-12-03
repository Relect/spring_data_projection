package com.example.projection.Exception;

public class EmpoyeeNotFoundException extends Exception {

    public EmpoyeeNotFoundException(long id) {
        super("Employee not found with id:" + id);
    }
}
