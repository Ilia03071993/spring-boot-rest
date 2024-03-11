package com.example.springbootrest.controller;

import com.example.springbootrest.entity.Department;
import com.example.springbootrest.entity.Employee;
import com.example.springbootrest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id,
                               @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}