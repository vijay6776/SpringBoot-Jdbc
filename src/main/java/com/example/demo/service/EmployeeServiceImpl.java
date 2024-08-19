package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Optional<Employee> update(Long id, Employee employee) {
        return employeeDao.update(id, employee);
    }

    @Override
    public boolean delete(Long id) {
        return employeeDao.delete(id);
    }
}

