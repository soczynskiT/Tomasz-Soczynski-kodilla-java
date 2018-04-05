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
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        final Product product1 = new Product("Test product no 1");
        final Product product2 = new Product("Test product no 2");

        final Item item1 = new Item(new BigDecimal(4.50), 10);
        item1.setProduct(product1);
        product1.getItemsList().add(item1);

        final Item item2 = new Item(new BigDecimal(2.00), 10);
        item2.setProduct(product2);
        product2.getItemsList().add(item2);

        final Item item3 = new Item(new BigDecimal(2.50), 3);
        item3.setProduct(product1);
        product1.getItemsList().add(item3);

        final Invoice testInvoice = new Invoice("Test invoice 7");
        item1.setInvoice(testInvoice);
        item2.setInvoice(testInvoice);
        item3.setInvoice(testInvoice);
        testInvoice.getAllItems().addAll(Arrays.asList(item1, item2, item3));

        //When
        invoiceDao.save(testInvoice);
        final Long testInvoiceId = testInvoice.getId();
        final Invoice readInvoice = invoiceDao.findOne(testInvoiceId);

        //Then
        Assert.assertNotEquals(null, readInvoice);

        //Clean
        invoiceDao.delete(testInvoiceId);
    }
}
