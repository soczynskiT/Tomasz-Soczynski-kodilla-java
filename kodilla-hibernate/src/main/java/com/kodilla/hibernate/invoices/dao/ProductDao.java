package com.kodilla.hibernate.invoices.dao;

import com.kodilla.hibernate.invoices.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
}
