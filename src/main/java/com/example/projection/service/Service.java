package com.example.projection.service;

import com.example.projection.model.Department;
import com.example.projection.model.Employee;
import com.example.projection.repository.DepartmentRepository;
import com.example.projection.repository.EmployeeProjection;
import com.example.projection.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;


    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public EmployeeProjection getProjectionByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public Employee getEmployeeById(long id) {
        return repository.getReferenceById(id);
    }

    public void updateEmployee(Employee employee) {
        Employee newEmployee = getEmployeeById(employee.getId());
        if (employee.getFirstName() != null) newEmployee.setFirstName(employee.getFirstName());
        if (employee.getLastName() != null) newEmployee.setLastName(employee.getLastName());
        if (employee.getPosition() != null) newEmployee.setPosition(employee.getPosition());
        if (employee.getSalary() != 0) newEmployee.setSalary(employee.getSalary());
        if (employee.getDepartment() != null) newEmployee.setDepartment(employee.getDepartment());
        repository.save(newEmployee);
    }

    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(long id) {
        return departmentRepository.getReferenceById(id);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void updateDepartment(Department department) {
        Department newDepartment = getDepartmentById(department.getId());
        if (department.getName() != null) newDepartment.setName(department.getName());
        departmentRepository.save(newDepartment);
    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }
}
