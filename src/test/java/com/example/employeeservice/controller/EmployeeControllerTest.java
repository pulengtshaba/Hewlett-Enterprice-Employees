package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.Employees;
import com.example.employeeservice.manager.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeManager employeeManager;

    private Employees employees;

    @BeforeEach
    public void setUp() {
        // Initialize a list of employees for testing
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "John", "Doe", "john.doe@example.com", "Developer"));
        employeeList.add(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Designer"));

        employees = new Employees();
        employees.setEmployeeList(employeeList);

        // Mock the behavior of employeeManager to return the employees list
        when(employeeManager.initializeEmployees()).thenReturn(employees);
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].first_name", is("John")))
                .andExpect(jsonPath("$[1].first_name", is("Jane")));
    }

    @Test
    public void testAddEmployee() throws Exception {
        String newEmployee = "{\"employee_id\":\"3\",\"first_name\":\"Alice\",\"last_name\":\"Johnson\",\"email\":\"alice.johnson@example.com\",\"title\":\"Engineer\"}";

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newEmployee))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.first_name", is("Alice")))
                .andExpect(jsonPath("$.title", is("Engineer")));
    }
}
