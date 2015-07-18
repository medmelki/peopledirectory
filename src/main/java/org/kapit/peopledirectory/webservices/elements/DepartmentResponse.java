package org.kapit.peopledirectory.webservices.elements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DepartmentResponse {

    public int id;
    public String name;
    public List<EmployeeResponse> employees;

    @XmlElement
    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
