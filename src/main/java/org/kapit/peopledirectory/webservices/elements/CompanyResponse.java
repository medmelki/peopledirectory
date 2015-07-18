package org.kapit.peopledirectory.webservices.elements;

import org.kapit.peopledirectory.model.Department;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CompanyResponse {

    public int id;
    public String name;
    public List<DepartmentResponse> departments;

    @XmlElement
    public List<DepartmentResponse> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentResponse> departments) {
        this.departments = departments;
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
