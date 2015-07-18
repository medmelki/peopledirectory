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

        List<Department> departments1 = new ArrayList<>();
        departments1.add(department1);
        departments1.add(department2);

        List<Department> departments2 = new ArrayList<>();
        departments2.add(department1);

        Company company = new Company(1, "kapit", departments1);
        Company company2 = new Company(2, "eXo", departments2);

        CompanyDAO companyDAO = new CompanyDAOImpl();
        try {
            companyDAO.addCompany(company);
            companyDAO.addCompany(company2);
            for (Company company1 : companyDAO.findAllCompanies()) {
                System.out.println(company1);
            }
            ;
        } catch (DAOException e) {
            e.printStackTrace();
        }

//        System.out.println("-----------------------------Removing Item : Company eXo");
//        try {
//            companyDAO.deleteCompany(company2);
//            System.out.println("-----After Deletion");
//            companyDAO.findAllCompanies();
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
        /*System.out.println("-----------------------------Removing Department : Company arts");
        try {
            //companyDAO.deleteDepartment(company, department2);
            //System.out.println("-----After Deletion");
            Employee emp7 = new Employee(7,"zeineb");
//            companyDAO.deleteEmployee(company,department2, emp4);
//            companyDAO.addEmployee(company,department2, emp7);
            //companyDAO.deleteCompany("eXo");
            //companyDAO.deleteDepartment("kapit","science");
            //companyDAO.deleteDepartment("kapit","arts");
            //companyDAO.deleteEmployee("kapit", 1, "rafik");
            companyDAO.addEmployee("kapit",1, emp7);
            companyDAO.findAllCompanies();
        } catch (DAOException e) {
            e.printStackTrace();
        }*/



    }
}
