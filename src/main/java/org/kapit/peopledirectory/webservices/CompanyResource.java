package org.kapit.peopledirectory.webservices;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.kapit.peopledirectory.dao.CompanyDAO;
import org.kapit.peopledirectory.dao.impl.CompanyDAOImpl;
import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.Company;
import org.kapit.peopledirectory.model.Department;
import org.kapit.peopledirectory.model.Employee;
import org.kapit.peopledirectory.webservices.elements.BooleanResponse;
import org.kapit.peopledirectory.webservices.elements.CompanyResponse;
import org.kapit.peopledirectory.webservices.elements.DepartmentResponse;
import org.kapit.peopledirectory.webservices.elements.EmployeeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Path("/company")
public class CompanyResource {
    private static final Logger LG = LoggerFactory.getLogger(CompanyResource.class);


    // URL : http://localhost:9095/peopledirectory/rest/company/all

    /**
     * Permet de récuperer tous les champs
     * des Companys existants dans la source de données
     *
     * @return la liste des companies
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public List<CompanyResponse> getCompanies() {

        LG.debug("Recuperation de la liste des companies");

        final List<CompanyResponse> companies = new ArrayList<>();

        CompanyDAO companyDAO = new CompanyDAOImpl();

        try {
            for (Company company : companyDAO.findAllCompanies()) {

                CompanyResponse response = new CompanyResponse();
                response.setId(company.getId());
                response.setName(company.getName());
                List<DepartmentResponse> departments = new ArrayList<>();
                for (Object department : company.getDepartments()) {
                    DepartmentResponse departmentResponse = new DepartmentResponse();
                    departmentResponse.setId(((BasicDBObject) department).getInt("_id"));
                    departmentResponse.setName((String) ((BasicDBObject) department).get("name"));
                    List<EmployeeResponse> employees = new ArrayList<>();
                    for (Object employee : (BasicDBList) ((BasicDBObject) department).get("employees")) {
                        EmployeeResponse employeeResponse = new EmployeeResponse();
                        employeeResponse.setId(((BasicDBObject) employee).getInt("_id"));
                        employeeResponse.setName((String) ((BasicDBObject) employee).get("name"));
                        employees.add(employeeResponse);
                    }
                    departmentResponse.setEmployees(employees);
                    departments.add(departmentResponse);

                }
                response.setDepartments(departments);
                companies.add(response);

            }
        } catch (DAOException e) {

            LG.error(e.getMessage());
        }
        return companies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employee/add/{companyName}/{departmentId}/{employeeId}/{name}")
    public BooleanResponse addEmployee(@PathParam("companyName") String companyName,
                                       @PathParam("departmentId") int departmentId,
                                       @PathParam("employeeId") int employeeId,
                                       @PathParam("name") String name) {
        BooleanResponse response = new BooleanResponse();

        response.setValue(true);

        CompanyDAO companyDAO = new CompanyDAOImpl();
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setName(name);

        try {
            companyDAO.addEmployee(companyName, departmentId, employee);
            LG.debug("Nouveau employé enregistré");

        } catch (DAOException e) {
            e.printStackTrace();
            response.setValue(false);
        }

        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employee/delete/{companyName}/{departmentId}/{name}")
    public BooleanResponse deleteEmployee(@PathParam("companyName") String companyName,
                                          @PathParam("departmentId") int departmentId,
                                          @PathParam("employeeId") int employeeId,
                                          @PathParam("name") String name) {
        BooleanResponse response = new BooleanResponse();

        response.setValue(true);

        CompanyDAO companyDAO = new CompanyDAOImpl();

        try {
            companyDAO.deleteEmployee(companyName, departmentId, name);
            LG.debug("Employé " + name + " supprimé");

        } catch (DAOException e) {
            e.printStackTrace();
            response.setValue(false);
        }

        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/department/delete/{companyName}/{departmentName}")
    public BooleanResponse deleteDepartment(@PathParam("companyName") String companyName,
                                            @PathParam("departmentName") String name) {
        BooleanResponse response = new BooleanResponse();

        response.setValue(true);

        CompanyDAO companyDAO = new CompanyDAOImpl();

        try {
            companyDAO.deleteDepartment(companyName, name);
            LG.debug("Département " + name + " supprimé");

        } catch (DAOException e) {
            e.printStackTrace();
            response.setValue(false);
        }

        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{companyName}")
    public BooleanResponse deleteCompany(@PathParam("companyName") String companyName) {
        BooleanResponse response = new BooleanResponse();

        response.setValue(true);

        CompanyDAO companyDAO = new CompanyDAOImpl();

        try {
            companyDAO.deleteCompany(companyName);
            LG.debug("Company " + companyName + " supprimé");

        } catch (DAOException e) {
            e.printStackTrace();
            response.setValue(false);
        }

        return response;
    }
}
