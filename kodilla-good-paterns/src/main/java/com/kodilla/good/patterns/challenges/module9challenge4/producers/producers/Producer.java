package com.kodilla.good.patterns.challenges.module9challenge4.producers.producers;


import com.kodilla.good.patterns.challenges.module9challenge4.producers.products.Product;

public interface Producer {

    void process();

    Product getProduct();
}
