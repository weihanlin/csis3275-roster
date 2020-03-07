package com.sw.roster.dao;

import com.sw.roster.model.Company;

public interface CompanyDao {
	
	Company findByCode(String code);
	
	int setUpCompany(Company company);
	
	void deleteByCode(String code);

}
