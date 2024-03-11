package com.example.springbootrest.service;

import com.example.springbootrest.entity.Department;
import com.example.springbootrest.entity.Employee;
import com.example.springbootrest.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    @Transactional(readOnly = true)
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department with id=%d not found".formatted(id)));
    }

    @Transactional
    public void addEmployeeToDepartment(Integer id,
                                        Employee employee) {
        departmentRepository.findById(id)
                .ifPresent(department -> {
                    employee.setDepartment(department);
                    departmentRepository.save(department);
                });
    }

    @Transactional
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void updateDepartment(Integer id, Department department) {
        Department updatableDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department with id=%d not found".formatted(id)));

        updatableDepartment.setName(department.getName());
        departmentRepository.save(updatableDepartment);
    }

    @Transactional
    public void deleteDepartment(Integer id) {
        if (!departmentRepository.existsById(id)) {
            throw new NoSuchElementException("Department with id=%d not found".formatted(id));
        }
        departmentRepository.deleteById(id);
    }
}
