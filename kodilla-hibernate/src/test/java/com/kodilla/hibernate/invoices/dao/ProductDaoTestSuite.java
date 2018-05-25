package com.kodilla.hibernate.invoices.dao;

import com.kodilla.hibernate.invoices.Invoice;
import com.kodilla.hibernate.invoices.Item;
import com.kodilla.hibernate.invoices.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {

    @Autowired
    ProductDao productDao;

    @Test
    public void testProductDaoSaveWithProduct() {
        //Given
        final Product testProduct = new Product("Test product 1");
        final Item testItem = new Item(new BigDecimal(24.12), 7777);
        final Item testItem2 = new Item(new BigDecimal(12), 10);
        testProduct.getItemsList().add(testItem);
        testProduct.getItemsList().add(testItem2);
        testItem.setProduct(testProduct);
        testItem2.setProduct(testProduct);

        //When
        productDao.save(testProduct);
        final Long testProductId = testProduct.getId();
        final Product readProduct = productDao.findOne(testProductId);

        //Then
        Assert.assertNotEquals(null, readProduct);

        //Clean
        productDao.delete(testProductId);

    }
}
