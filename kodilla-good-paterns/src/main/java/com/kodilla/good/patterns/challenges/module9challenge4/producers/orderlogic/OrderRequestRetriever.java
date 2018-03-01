package com.kodilla.good.patterns.challenges.module9challenge4.producers.orderlogic;

import com.kodilla.good.patterns.challenges.module9challenge4.producers.ShopUser;
import com.kodilla.good.patterns.challenges.module9challenge4.producers.producers.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.module9challenge4.producers.producers.Producer;
import com.kodilla.good.patterns.challenges.module9challenge4.producers.products.Product;
import com.kodilla.good.patterns.challenges.module9challenge4.producers.products.Tomato;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieveRequest() {
        final ShopUser newShopUser = new ShopUser("FullName", "FullAdress", 25);
        final Producer producer = new ExtraFoodShop();
        final Product product = new Tomato();
        final int quantityOfProduct = 10;
        final LocalDate orderDate = LocalDate.now();

        return new OrderRequest(newShopUser, producer, product, quantityOfProduct, orderDate);
    }
}
