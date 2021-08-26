package com.company;

import com.company.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();

    public void add(Product product) {
        this.products.put(product.getId(), product);
    }
}
