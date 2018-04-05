package com.kodilla.hibernate.invoices.dao;

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
public class ItemDaoTestSuite {

    @Autowired
    ItemDao itemDao;

    @Test
    public void testSaveItemDaoWithItem() {
        //Given
        final Item testItem = new Item(new BigDecimal(24.12), 12);

        //When
        itemDao.save(testItem);
        final Long testItemId = testItem.getId();
        final Item readItem = itemDao.findOne(testItemId);

        //Then
        Assert.assertNotEquals(null, readItem);

        //Clean
        itemDao.delete(testItemId);
    }
}
