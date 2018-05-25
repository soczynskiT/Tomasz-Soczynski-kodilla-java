package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTest {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SearchFacade searchFacade;

    @Test
    public void testSearchFacadeForCompanies() {
        //Given
        final Company company1 = new Company("Komputronic");
        final Company company2 = new Company("Biedronka");
        companyDao.save(company1);
        companyDao.save(company2);

        //When
        List<Company> foundedCompanies = searchFacade.searchForComapnies("n");
        List<Company> foundedCompanies2 = searchFacade.searchForComapnies("9");

        //Then
        Assert.assertEquals(2, foundedCompanies.size());
        Assert.assertEquals(0, foundedCompanies2.size());

        //Clear
        companyDao.delete(company1.getId());
        companyDao.delete(company2.getId());

    }

    @Test
    public void testSearchFacadeForEmployees() {
        //Given
        final Employee employee1 = new Employee("Jhon", "Patterson");
        final Employee employee2 = new Employee("Peter", "Svenson");
        employeeDao.save(employee1);
        employeeDao.save(employee2);

        //When
        List<Employee> foundedEmployees = searchFacade.searchForEmployees("son");
        List<Employee> foundedEmployees2 = searchFacade.searchForEmployees("9");

        //Then
        Assert.assertEquals(2, foundedEmployees.size());
        Assert.assertEquals(0, foundedEmployees2.size());

        //Clear
        employeeDao.delete(employee1.getId());
        employeeDao.delete(employee2.getId());

    }

}