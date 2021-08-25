package com.company;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<LineProduct> productsInCart = new ArrayList<>();

    public void addProduct(LineProduct lineProduct) {
        productsInCart.add(lineProduct);
    }

    public void deleteProduct(LineProduct lineProductToDelete) {
        boolean deleteLineProduct = false;
        for (LineProduct lineProduct : productsInCart) {
            if (lineProduct.getProductId().equals(lineProductToDelete.getProductId())) {
                if (lineProductToDelete.getQuantity() == lineProduct.getQuantity()) {
                    deleteLineProduct = true;
                } else {
                    lineProduct.reduceQuantityBy(lineProductToDelete.getQuantity());
                }
            }
        }
        if (deleteLineProduct) {
            productsInCart.remove(lineProductToDelete);
        }
    }

    private double getTotalPrice() {
        double totalPrice = 0;

        for (LineProduct lineProduct : productsInCart) {
            if (lineProduct.getQuantity() > 2) {
                totalPrice += 0.9 * lineProduct.getQuantity() * lineProduct.getSinglePrice();
            } else {
                totalPrice += lineProduct.getQuantity() * lineProduct.getSinglePrice();
            }
        }
        if (totalPrice > 100) {
            totalPrice *= 0.9;
        }
        return totalPrice;
    }

    private int getTotalNumberOfProducts(){
        int totalNumberOfProducts = 0;
        for(LineProduct lineProduct : productsInCart){
            totalNumberOfProducts += lineProduct.getQuantity();
        }
        return totalNumberOfProducts;
    }

    private double getTotalDiscount(double totalPrice) {
        double pricePriorDiscount = 0;
        for(LineProduct lineProduct : productsInCart){
            pricePriorDiscount += lineProduct.getSinglePrice()* lineProduct.getQuantity();
        }
        return pricePriorDiscount - totalPrice;
    }

    public void showProductsInfo() {
        double totalPrice = getTotalPrice();
        double totalDiscount = getTotalDiscount(totalPrice);
        int totalNumberOfProducts = getTotalNumberOfProducts();

        for (LineProduct lineProduct : productsInCart) {
            System.out.printf("Product -> %s\nQuantity -> %d\nPrice -> %.2f\n",
                    lineProduct.getProductName(),
                    lineProduct.getQuantity(),
                    lineProduct.getSinglePrice() * lineProduct.getQuantity());
            System.out.println("------------------------------------------------------------");
        }
        System.out.println();
        System.out.printf("Total number of products -> %d \nTotal Price -> %.2f \nTotal Discount -> %.2f\n", totalNumberOfProducts, totalPrice, totalDiscount);
        System.out.println();
    }
}
