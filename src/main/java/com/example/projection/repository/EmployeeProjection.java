package com.example.projection.repository;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
    String getPosition();
    DepartmentView getDepartment();

    interface DepartmentView {
        String getName();
    }
}
