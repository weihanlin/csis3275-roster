package com.sw.roster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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
	@Transactional
	public int addEmployee(Employee employee, String code) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("code",code);
		params.put("employee_id", employee.getId());
		

		String sql = "INSERT INTO companies_employees (code, employee_id) "
				+ "VALUES(:code, :employee_id)";


		return namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void deleteById(int employee_id) {
		String sql = "DELETE FROM companies_employees WHERE employee_id = :employee_id";
		int rst = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("employee_id",employee_id));

		sql = "DELETE FROM employees WHERE employee_id = :employee_id";
		
		if(rst > 0)
			rst = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("employee_id",employee_id));
		System.out.println("rst:" + rst);
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
			employee.setAvailiability(rs.getInt("availiability"));
			
			return employee;
		}
		
	}


	@Override
	public List<Employee> findByCode(String code) {

		String sql = "SELECT * FROM employees WHERE employee_id IN "
				+ "(SELECT employee_id FROM companies_employees WHERE code = :code )";
		List<Employee> result = namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource("code",code), new EmployeeMapper());
		return result;
	}

	@Override
	public int getEmployeeID(Employee employee) {
		// TODO Auto-generated method stub
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", employee.getEmail());
        
		String sql = "SELECT employee_id FROM employees WHERE email=:email";
		
        int result = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        
		
		return result;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", employee.getId());
        params.put("email", employee.getEmail());
        params.put("first_name", employee.getFirst_name());
		params.put("last_name",employee.getLast_name());
		params.put("login_id",employee.getLogin_id());
		params.put("password",employee.getPassword());
		params.put("availiability",employee.getAvailiability());
		
        
		String sql = "UPDATE employees SET email=:email,first_name=:first_name,"
				+ "last_name=:last_name,login_id=:login_id,password=:password,availiability=:availiability WHERE employee_id=:id";
		namedParameterJdbcTemplate.update(sql,params);
	}

	@Override
	public String findCode(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("employee_id", employee.getId());
		System.out.println(employee.getId());
		String sql = "SELECT code FROM companies_employees WHERE employee_id=:employee_id";
		String result = namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
		return result;
	}


}
