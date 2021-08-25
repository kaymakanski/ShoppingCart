package com.company;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void add(Product product){
        this.products.put(product.getId(), product);
    }
}
