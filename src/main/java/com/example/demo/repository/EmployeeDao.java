package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeDao {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    Optional<Employee> update(Long id, Employee employee);
    boolean delete(Long id);
}
