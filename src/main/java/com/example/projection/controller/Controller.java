package com.example.projection.controller;

import com.example.projection.model.Department;
import com.example.projection.model.Employee;
import com.example.projection.repository.EmployeeProjection;
import com.example.projection.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(service.getAllEmployee());
    }

    @GetMapping("/employee/{name}")
    public ResponseEntity<EmployeeProjection> getProjection(@PathVariable String name) {
        EmployeeProjection projection = service.getProjectionByFirstName(name);
        return projection == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(projection);
    }

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/emp")
    public ResponseEntity<String > updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Должен содержать ID");
        }
        service.updateEmployee(employee);
        return ResponseEntity.ok("employee обновлён");
    }

    @DeleteMapping("/emp/{id}")
    public void deleteEmployee(@PathVariable long id) {
        service.deleteEmployee(id);
    }

    @GetMapping("/dep/{id}")
    public ResponseEntity<Department> getDepById(@PathVariable long id) {
        Department department = service.getDepartmentById(id);
        return department == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(department);
    }

    @PostMapping("/dep")
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @PutMapping("/dep")
    public ResponseEntity<String > updateDepartment(@RequestBody Department department) {
        if (department.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Должен содержать ID");
        }
        service.updateDepartment(department);
        return ResponseEntity.ok("department обновлён");
    }

    @DeleteMapping("/dep/{id}")
    public void deleteDepartment(@PathVariable long id) {
        service.deleteDepartment(id);
    }
}
