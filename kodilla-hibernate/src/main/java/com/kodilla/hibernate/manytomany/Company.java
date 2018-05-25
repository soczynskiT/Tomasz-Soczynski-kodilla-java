package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompaniesWithNameBegins",
        query = "SELECT * FROM COMPANIES " +
                "WHERE COMPANY_NAME LIKE CONCAT(:ABC,'%')",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.retrieveCompaniesWhichNamesIncludes",
        query = "FROM Company WHERE name LIKE :word"
)
@Entity
@Table(name = "COMPANIES")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "COMPANY_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "COMPANY_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
