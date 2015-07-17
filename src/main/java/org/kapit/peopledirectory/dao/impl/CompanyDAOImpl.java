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
            DBObject departmentDB = new BasicDBObject();
            departmentDB.put("_id", dep.getId());
            departmentDB.put("name", dep.getName());
            BasicDBList dbEmbeddedList = new BasicDBList();
            for (Employee emp : dep.getEmployees()) {
                DBObject employeeDB = new BasicDBObject();
                employeeDB.put("_id", emp.getId());
                employeeDB.put("name", emp.getName());
                dbEmbeddedList.add(employeeDB);
            }
            departmentDB.put("employees", dbEmbeddedList);
            dbList.add(departmentDB);
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

        collection.update(new BasicDBObject("name", companyName), new BasicDBObject("$pull", new BasicDBObject("departments", new BasicDBObject("name", departmentName))));
    }

    @Override
    public void addEmployee(String companyName, int departmentId, Employee employee) throws DAOException {

        collection.update(new BasicDBObject("name", companyName), new BasicDBObject("$push", new BasicDBObject("departments.0.employees", new BasicDBObject("_id", employee.getId()).append("name", employee.getName()))));
//        collection.update(new BasicDBObject("name", companyName), new BasicDBObject("$push", new BasicDBObject("departments", new BasicDBObject("employees", new BasicDBObject("name", employee.getName()).append("_id", employee.getId())))));
    }

    @Override
    public void deleteEmployee(String companyName, int departmentId, String employeeName) throws DAOException {

//        collection.update(new BasicDBObject("name", companyName).append("departments.name", departmentName), new BasicDBObject("$pull", new BasicDBObject("departments", new BasicDBObject("employees", new BasicDBObject("name", employeeName)))));
//        DBCursor cursor = collection.find(new BasicDBObject("name", companyName).append("departments.name", departmentName));
//        List<DBObject> dbObjects = cursor.toArray();
        collection.update(new BasicDBObject("name", companyName), new BasicDBObject("$pull", new BasicDBObject("departments." + (departmentId - 1) + ".employees", new BasicDBObject("name", employeeName))));
    }

}
