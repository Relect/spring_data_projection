package com.example.projection.Exception;

public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException(long id) {
        super("Department not found with id:" + id);
    }
}
