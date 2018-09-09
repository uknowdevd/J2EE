package com.sparc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sparc.entity.Person;

public class PersonDAO {

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	
	private String preparedString = "Insert into person.name values (?,?)";

	public void addPerson(Person person) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(preparedString, new Object[] { person.getFirstName(), person.getLastName() });

	}

}
