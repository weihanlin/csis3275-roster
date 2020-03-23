package com.sw.roster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sw.roster.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("employee_id", id);
        
		String sql = "SELECT * FROM employees WHERE employee_id=:employee_id";
		
        Employee result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new EmployeeMapper());
        
		return result;
	}

	@Override
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email",employee.getEmail());
		params.put("first_name", employee.getFirst_name());
		params.put("last_name",employee.getLast_name());
		params.put("login_id",employee.getLogin_id());
		params.put("password",employee.getPassword());
		params.put("availiability",employee.getAvailiability());
		
		

		String sql = "INSERT INTO employees (email, first_name, last_name, login_id, password, availiability) "
				+ "VALUES(:email, :first_name, :last_name, :login_id, :password, 0)";


		return namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}
	
	
	private static final class EmployeeMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();

			employee.setId(rs.getInt("employee_id"));
			employee.setEmail(rs.getString("email"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setLogin_id(rs.getString("login_id"));
			employee.setAvailiability(rs.getInt("availiablity"));
			
			return employee;
		}
		
	} 

}
