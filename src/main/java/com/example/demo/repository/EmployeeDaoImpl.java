package com.example.demo.repository;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new EmployeeRowMapper())
                .stream()
                .findFirst();
    }

    @Override
    public Employee save(Employee employee) {
        String sql = "INSERT INTO employee (name, role) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole());
        return findByName(employee.getName()).orElse(null);
    }

    @Override
    public Optional<Employee> update(Long id, Employee employee) {
        String sql = "UPDATE employee SET name = ?, role = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, employee.getName(), employee.getRole(), id);
        return rows > 0 ? findById(id) : Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    private Optional<Employee> findByName(String name) {
        String sql = "SELECT * FROM employee WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new EmployeeRowMapper())
                .stream()
                .findFirst();
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setRole(rs.getString("role"));
            return employee;
        }
    }
}

