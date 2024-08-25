package com.example.employeeservice.manager;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.Employees;

public class EmployeeManager {

    public Employees initializeEmployees() {
        Employees employees = new Employees();

        employees.getEmployeeList().add(new Employee("1", "John", "Doe", "john.doe@example.com", "Developer"));
        employees.getEmployeeList().add(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Manager"));
        employees.getEmployeeList().add(new Employee("3", "Bob", "Brown", "bob.brown@example.com", "Designer"));

        return employees;
    }
}