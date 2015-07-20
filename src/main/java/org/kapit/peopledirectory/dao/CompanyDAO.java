package org.kapit.peopledirectory.dao;


import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Employee;

import java.util.Set;

public interface CompanyDAO {

    void addCompany(Company company) throws Exception;
    void deleteCompany(String companyName) throws Exception;
    public Set<Company> findAllCompanies() throws Exception;

    void deleteDepartment(String companyName, String departmentName) throws Exception;

    void addEmployee(String companyName, int departmentId, Employee employee) throws Exception;
    void deleteEmployee(String companyName, int departmentId, String employeeName) throws Exception;

}
