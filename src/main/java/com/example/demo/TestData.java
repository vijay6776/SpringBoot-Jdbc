package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestData /*implements CommandLineRunner*/ {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void run(String... args) throws Exception {
////		String sql="insert into employee values (?,?,?)";
////		int count=jdbcTemplate.update(sql,1,"Vijay","Medak");
////		System.out.println("Inserted Rows : "+count);
//		
//		String sql="update employee set employeeName=?,employeeCity=? where employeeId=?";
//		int count=jdbcTemplate.update(sql,"AKULA VIJAY KUMAR","MEDAK",1);
//		System.out.println("updated successfully");
//	}

}
