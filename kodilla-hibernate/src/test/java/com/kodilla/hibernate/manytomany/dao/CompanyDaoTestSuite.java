package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        final Employee johnSmith = new Employee("John", "Smith");
        final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        final Company softwareMachine = new Company("Software Machine");
        final Company dataMaesters = new Company("Data Maesters");
        final Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        final Long softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        final Long dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        final Long greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(null, softwareMachineId);
        Assert.assertNotEquals(null, dataMaestersId);
        Assert.assertNotEquals(null, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Transactional
    @Test
    public void testNamedQueries() {
        //Given
        final Employee johnSmith = new Employee("John", "Kovac");
        final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        final Company softwareMachine = new Company("Software Machine");
        final Company dataMaesters = new Company("Software Maesters");
        final Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        final Long softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        final Long dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        final Long greyMatterId = greyMatter.getId();

        //When
        final List<Employee> requestedEmployeesList = employeeDao.retrieveEmployeesWithName("kovac");
        final List<Company> requestedCompaniesList = companyDao.retrieveCompaniesWithNameBegins("sof");

        //Then
        Assert.assertEquals(1, requestedEmployeesList.size());
        Assert.assertEquals(2, requestedCompaniesList.size());

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
