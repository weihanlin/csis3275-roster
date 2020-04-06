package com.sw.roster.dao;

import java.util.List;

import com.sw.roster.model.Company;

public interface CompanyDao {
	
	Company findByCode(String code);
	
	int setUpCompany(Company company);
	
	int setUpCompany(Company company, int id);
	
	void deleteByCode(String code);
	
	List<Company> findAll();
	
	List<Company> findCompanies(int id);

}
