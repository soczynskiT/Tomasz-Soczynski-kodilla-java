package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchFacade {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Company> searchForComapnies(final String word) {
        List<Company> foundedCompanies = companyDao.retrieveCompaniesWhichNamesIncludes("%" + word + "%");
        return Optional.ofNullable(foundedCompanies).orElseGet(ArrayList::new);
    }

    public List<Employee> searchForEmployees(final String word) {
        List<Employee> foundedEmployees = employeeDao.retrieveEmployeesWhichNamesIncludes("%" + word + "%");
        return Optional.ofNullable(foundedEmployees).orElseGet(ArrayList::new);
    }
}
