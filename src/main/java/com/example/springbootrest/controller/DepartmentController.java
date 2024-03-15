package com.example.springbootrest.controller;

import com.example.springbootrest.entity.Department;
import com.example.springbootrest.entity.Employee;
import com.example.springbootrest.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Integer id) {
        return departmentService.findDepartmentById(id);
    }

    //@GetMapping
//public List<Department> findAllDepartments() {
//    return departmentService.findAllEmployeesWithDepartments();
//}
    @PostMapping("/{id}/add-employee")
    public void addEmployeeToDepartment(@PathVariable Integer id,
                                        @RequestBody Employee employee) {
        departmentService.addEmployeeToDepartment(id, employee);
    }


    @PostMapping
    public void saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable Integer id,
                                 @RequestBody Department department) {
        departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }
}
