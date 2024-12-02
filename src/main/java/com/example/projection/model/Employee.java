package com.example.projection.model;


import jakarta.persistence.*;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private int salary;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;
}
