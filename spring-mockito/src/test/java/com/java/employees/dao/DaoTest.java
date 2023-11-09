package com.java.employees.dao;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.java.employees.model.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class DaoTest {

	@Autowired
	EmployeeRepository repository;
	
	@Test
	public void testAddUser() {
		Employee em=new Employee("Admin","Manager");
		repository.save(em);
		
		Iterable<Employee>emps=repository.findAll();
		Assertions.assertThat(emps).extracting(Employee :: getFirstName).containsOnly("Admin");
	}
}
