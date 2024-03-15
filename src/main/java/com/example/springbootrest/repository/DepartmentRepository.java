package com.example.springbootrest.repository;

import com.example.springbootrest.entity.Department;
import com.example.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("select d from Department d left join fetch d.employees")
    List<Department> findAllDepartments();

    @Query("select d from Department d left join fetch d.employees where d.id = :id")
    Optional<Department> findDepartmentById(Integer id);

//    @Query("SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees")
//    List<Department> findAllDepartmentsWithEmployees();
}
