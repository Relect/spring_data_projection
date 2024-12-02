package com.example.projection.model;


import jakarta.persistence.ManyToOne;

public class Employee {

    private Long Id;
    private String firstName;
    private String lastName;
    private String position;
    private int salary;

    @ManyToOne()
    private Department department;
}
