package com.company;

import java.util.Objects;

public class LineProduct {
    private String productId;
    private String productName;
    private int quantity;
    private double singlePrice;

    public LineProduct(String productId,String productName, int quantity, double singelPrice){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.singlePrice = singelPrice;
    }
    public LineProduct(String productId, int quantityToRemove){
        this.productId = productId;
        quantity = quantityToRemove;
    }

    public double getSinglePrice(){
        return singlePrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineProduct that = (LineProduct) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    public void reduceQuantityBy(int quantityToReduceBy) {
        if(this.quantity < quantityToReduceBy || quantityToReduceBy < 0){
            System.out.println("Please enter a valid quantity to reduce by!");
            return;
        }
        this.quantity -= quantityToReduceBy;
    }
}
