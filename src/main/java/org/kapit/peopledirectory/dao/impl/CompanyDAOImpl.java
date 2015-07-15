package org.kapit.peopledirectory.dao.impl;

import com.mongodb.*;
import org.kapit.peopledirectory.dao.CompanyDAO;
import org.kapit.peopledirectory.dao.Connection;
import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;

import java.util.List;


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
            dbList.add(new BasicDBObject("employees", dbEmbeddedList));
        }
        companyDB.put("departments", dbList);
        collection.save(companyDB);

    }

    @Override
    public void deleteCompany(Company company) throws DAOException {

        BasicDBObject document = new BasicDBObject();
        if (company.getName() != null) {
            document.put("name", company.getName());
        }
        collection.remove(document);
    }

    @Override
    public void findAllCompanies() throws DAOException {

        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    @Override
    public void deleteDepartment(Company company, Department department) throws DAOException {

        DBObject companyDB = new BasicDBObject();
        companyDB.put("_id", company.getId());
        companyDB.put("name", company.getName());
        BasicDBList dbList = new BasicDBList();
        for (Department dep : company.getDepartments()) {
            if (dep.getName().equals(department.getName())) {
                company.getDepartments().remove(dep);
                continue;
            }
            dbList.add(new BasicDBObject("_id", dep.getId()));
            dbList.add(new BasicDBObject("name", dep.getName()));
            BasicDBList dbEmbeddedList = new BasicDBList();
            for (Employee emp : dep.getEmployees()) {
                dbEmbeddedList.add(new BasicDBObject("_id", emp.getId()));
                dbEmbeddedList.add(new BasicDBObject("name", emp.getName()));
            }
            dbList.add(new BasicDBObject("employees", dbEmbeddedList));
        }
        companyDB.put("departments", dbList);

        DBObject query = new BasicDBObject("_id", company.getId());

        collection.update(query, companyDB);
    }

    @Override
    public void addEmployee(Company company, Department department, Employee employee) throws DAOException {

        DBObject companyDB = new BasicDBObject();
        companyDB.put("_id", company.getId());
        companyDB.put("name", company.getName());
        BasicDBList dbList = new BasicDBList();
        for (Department dep : company.getDepartments()) {
            dbList.add(new BasicDBObject("_id", dep.getId()));
            dbList.add(new BasicDBObject("name", dep.getName()));
            BasicDBList dbEmbeddedList = new BasicDBList();
            List<Employee> employees = dep.getEmployees();
            employees.add(employee);
            for (Employee emp : employees) {
                dbEmbeddedList.add(new BasicDBObject("_id", emp.getId()));
                dbEmbeddedList.add(new BasicDBObject("name", emp.getName()));
            }
            dbList.add(new BasicDBObject("employees", dbEmbeddedList));
        }
        companyDB.put("departments", dbList);

        DBObject query = new BasicDBObject("_id", company.getId());

        collection.update(query, companyDB);
    }

    @Override
    public void deleteEmployee(Company company, Department department, Employee employee) throws DAOException {

        DBObject companyDB = new BasicDBObject();
        companyDB.put("_id", company.getId());
        companyDB.put("name", company.getName());
        BasicDBList dbList = new BasicDBList();
        for (Department dep : company.getDepartments()) {
            dbList.add(new BasicDBObject("_id", dep.getId()));
            dbList.add(new BasicDBObject("name", dep.getName()));
            BasicDBList dbEmbeddedList = new BasicDBList();
            for (Employee emp : dep.getEmployees()) {
                if (emp.getName().equals(employee.getName())) {
                    dep.getEmployees().remove(emp);
                    continue;
                }
                dbEmbeddedList.add(new BasicDBObject("_id", emp.getId()));
                dbEmbeddedList.add(new BasicDBObject("name", emp.getName()));
            }
            dbList.add(new BasicDBObject("employees", dbEmbeddedList));
        }
        companyDB.put("departments", dbList);

        DBObject query = new BasicDBObject("_id", company.getId());

        collection.update(query, companyDB);

    }
}
