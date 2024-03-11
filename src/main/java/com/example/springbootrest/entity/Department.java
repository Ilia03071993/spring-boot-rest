package com.example.springbootrest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
//cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
//    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
//            fetch = FetchType.EAGER)
//    private List<Employee> employees;
//
//    public void setEmployees(List<Employee> employees) {
//        for (Employee employee : employees) {
//            employee.setDepartment(this);
//        }
//        this.employees = employees;
//    }
}