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

import com.sw.roster.model.Company;


@Repository
public class CompanyDaoImpl implements CompanyDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Company findByCode(String code) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        
		String sql = "SELECT * FROM companies WHERE code=:code";
		
        Company result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new CompanyMapper());
        
		return result;
	}
	
	@Override
	public int setUpCompany(Company company) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", company.getCode());
		params.put("name", company.getName());
		params.put("address", company.getAddress());

		String sql = "INSERT INTO companies VALUES(:code, :name, :address)";


		return namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public void deleteByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM companies WHERE code = :code";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("code",code));
		
	}



	public List<Company> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM companies";
		List<Company> result = namedParameterJdbcTemplate.query(sql, new CompanyMapper());
		
		return result;
	} 


	private static final class CompanyMapper implements RowMapper<Company>{

		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company company = new Company();

			company.setCode(rs.getString("code"));
			company.setName(rs.getString("company_name"));
			company.setAddress(rs.getString("address"));
			
			return company;
		}
		
	}




	
	

}
