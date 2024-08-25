package com.example.employeeservice.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeeList = new ArrayList<>();

    // Constructor: Hard-coding the list of employees
    public Employees() {
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
