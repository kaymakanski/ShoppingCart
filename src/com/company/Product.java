package com.company;

public class Product {
    private String id;
    private String name;
    private double price;
    private ProductType productType;

    public Product(String id, String name, double price, ProductType productType){
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product(){}

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
