package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {
    List<Company> retrieveCompaniesWithNameBegins(@Param("ABC") final String nameBeginning);

    List<Company> retrieveCompaniesWhichNamesIncludes(@Param("word") final String word);
}
