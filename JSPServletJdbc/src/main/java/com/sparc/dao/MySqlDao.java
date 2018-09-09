package com.sparc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sparc.entity.PersonTO;
import com.sparc.filter.LoggingFilter;

public class MySqlDao {

	private String preparedString = "Insert into person.name values (?,?)";

	Logger logger = LogManager.getLogger(MySqlDao.class);

	public void writeDataBase(String firstName, String lastName) throws Exception{
		Connection connect = null;
		 PreparedStatement preparedStatement = null;
      try
      {
		connect = dbInit();
		preparedStatement = connect.prepareStatement(preparedString);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		logger.info("Printing the data before inssert " + firstName + " " + lastName);
		preparedStatement.executeUpdate();
      }
      finally {
    	  if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connect != null) {
				connect.close();
			}
      }
		
	}

	public List<PersonTO> readDataBase() throws Exception {
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			connect = dbInit();

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from person.name");
			return writeResultSet(resultSet);

		} finally {
			close(connect, statement, resultSet);
		}

	}

	private Connection dbInit()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection connect = null;
		String url = "jdbc:mysql://localhost:3306/person?useLegacyDatetimeCode=false&serverTimezone=America/New_York";

		String user = "dheeru";
		String pass = "dheeru";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connect = DriverManager.getConnection(url, user, pass);
		return connect;
	}

	private List<PersonTO> writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		List<PersonTO> personList = new ArrayList<PersonTO>();
		while (resultSet.next()) {
			PersonTO person = new PersonTO();
			person.setFirstName(resultSet.getString("firstname"));
			person.setLastName(resultSet.getString("lastname"));
		personList.add(person);
			
		}
		return personList;
	}

	private void close(Connection connect, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
