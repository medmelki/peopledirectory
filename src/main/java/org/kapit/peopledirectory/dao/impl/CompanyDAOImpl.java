package org.kapit.peopledirectory.dao.impl;

import com.mongodb.*;
import org.kapit.peopledirectory.dao.CompanyDAO;
import org.kapit.peopledirectory.dao.Connection;
import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;


public class CompanyDAOImpl implements CompanyDAO {

    private Connection connection = new Connection();
    private DBCollection collection = connection.getDataBase().getCollection("company");


    @Override
    public void addCompany(Company company) throws DAOException {
        DBObject companyDB = new BasicDBObject();
        companyDB.put("_id", company.getId());
        companyDB.put("name", company.getName());
        BasicDBList dbList = new BasicDBList();
        for (Department dep : company.getDepartments()) {
            dbList.add(new BasicDBObject("_id", dep.getId()));
            dbList.add(new BasicDBObject("name", dep.getName()));
            BasicDBList dbEmbeddedList = new BasicDBList();
            for (Employee emp : dep.getEmployees()) {
                dbEmbeddedList.add(new BasicDBObject("_id", emp.getId()));
                dbEmbeddedList.add(new BasicDBObject("name", emp.getName()));
            }
            dbList.add(new BasicDBObject("Employees", dbEmbeddedList));
        }
        companyDB.put("Departments", dbList);
        collection.save(companyDB);

    }

    @Override
    public void deleteCompany(Company company) throws DAOException {

    }

    @Override
    public void findAllCompanies() throws DAOException {

        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    @Override
    public void addDepartment(Company company, Department department) throws DAOException {

    }

    @Override
    public void deleteDepartment(Company company, Department department) throws DAOException {

    }

    @Override
    public void addEmployee(Company company, Department department, Employee employee) throws DAOException {

    }

    @Override
    public void deleteEmployee(Company company, Department department, Employee employee) throws DAOException {

    }
}
