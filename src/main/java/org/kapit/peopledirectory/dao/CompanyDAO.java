package org.kapit.peopledirectory.dao;


import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;

public interface CompanyDAO {

    void addCompany(Company company) throws DAOException;
    void deleteCompany(Company company) throws DAOException;
    void findAllCompanies() throws DAOException;

    void addDepartment(Company company, Department department) throws DAOException;
    void deleteDepartment(Company company, Department department) throws DAOException;

    void addEmployee(Company company, Department department, Employee employee) throws DAOException;
    void deleteEmployee(Company company, Department department, Employee employee) throws DAOException;

}
