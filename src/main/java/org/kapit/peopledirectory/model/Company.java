package org.kapit.peopledirectory.model;


import java.util.List;

public class Company {

    int id;
    String name;
    List<Department> departments;

    public Company(int id, String name, List<Department> departments) {
        this.id = id;
        this.name = name;
        this.departments = departments;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}
