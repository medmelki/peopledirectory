package org.kapit.peopledirectory.dao.impl;

import com.mongodb.*;
import org.kapit.peopledirectory.dao.CompanyDAO2;
import org.kapit.peopledirectory.dao.Connection;
import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;


public class CompanyDAOImpl2 implements CompanyDAO2 {

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
    public void deleteCompany(String companyName) throws DAOException {

        BasicDBObject document = new BasicDBObject();
        if (companyName != null) {
            document.put("name", companyName);
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
    public void deleteDepartment(String companyName, String departmentName) throws DAOException {

        BasicDBList list = new BasicDBList();
        list.add(new BasicDBObject("name", departmentName));
        list.add(new BasicDBObject("_id", 1));

        collection.update(new BasicDBObject("name", companyName), new BasicDBObject("$pull", new BasicDBObject("departments", new BasicDBObject("name", departmentName))));
    }

    @Override
    public void addEmployee(String companyName, String departmentName, Employee employee) throws DAOException {

    }

    @Override
    public void deleteEmployee(String companyName, String departmentName, String employeeName) throws DAOException {

    }

}
