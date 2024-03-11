package com.example.springbootrest.repository;

import com.example.springbootrest.entity.Department;
import com.example.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
