package org.kapit.peopledirectory;

import org.kapit.peopledirectory.dao.CompanyDAO;
import org.kapit.peopledirectory.dao.impl.CompanyDAOImpl;
import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TOSHIBA on 14/07/2015.
 */
public class Tester {

    public static void main(String[] args) {

        Employee emp1 = new Employee(1,"rafik");
        Employee emp2 = new Employee(2,"med");
        Employee emp3 = new Employee(3,"ali");
        Employee emp4 = new Employee(4,"melki");
        Employee emp5 = new Employee(5,"anis");
        Employee emp6 = new Employee(6,"najib");

        List employees1 = new ArrayList();
        employees1.add(emp1);
        employees1.add(emp2);
        employees1.add(emp3);
        Department department1 = new Department(1,"science", employees1);

        List employees2 = new ArrayList();
        employees2.add(emp4);
        employees2.add(emp5);
        employees2.add(emp6);
        Department department2 = new Department(2,"arts", employees2);

        List departments1 = new ArrayList();
        departments1.add(department1);
        departments1.add(department2);

        Company company = new Company(1, "kapit", departments1);

        CompanyDAO companyDAO = new CompanyDAOImpl();
        try {
            companyDAO.addCompany(company);
            companyDAO.findAllCompanies();
        } catch (DAOException e) {
            e.printStackTrace();
        }



    }
}
