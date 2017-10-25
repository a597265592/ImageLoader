package com.example.admin.imageloader.factoryPattern;

/**
 * Created by admin on 2017/5/8.
 */

public class ConcreteFactory extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
