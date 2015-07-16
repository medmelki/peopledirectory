package org.kapit.peopledirectory.dao;


import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;

public interface CompanyDAO2 {

    void addCompany(Company company) throws DAOException;
    void deleteCompany(String companyName) throws DAOException;
    void findAllCompanies() throws DAOException;

    void deleteDepartment(String companyName, String departmentName) throws DAOException;

    void addEmployee(String companyName, String departmentName, Employee employee) throws DAOException;
    void deleteEmployee(String companyName, String departmentName, String employeeName) throws DAOException;

}
