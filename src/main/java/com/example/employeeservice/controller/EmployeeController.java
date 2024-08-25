package com.example.employeeservice.controller;

import com.example.employeeservice.manager.EmployeeManager;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.Employees;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Employees employees;

    public EmployeeController() {
        EmployeeManager manager = new EmployeeManager();
        this.employees = manager.initializeEmployees();
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees.getEmployeeList();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.getEmployeeList().add(employee);
        return employee;
    }
}
