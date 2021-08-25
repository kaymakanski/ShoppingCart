package com.company;

public class Product {
    private final String id;
    private final String name;
    private final double price;
    private final ProductType productType;

    public Product(String id, String name, double price, ProductType productType){
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }
}
