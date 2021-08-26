package com.company.shoppingCart;

import com.company.products.ProductType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCalculator {
    Map<ProductType, List<ShoppingCartItem>> typeToItems = new HashMap<>();

    public PriceCalculator(ShoppingCart shoppingCart) {
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getItems()) {
            addShoppingCartItem(shoppingCartItem);
        }
    }

    private void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        if (typeToItems.get(shoppingCartItem.getProduct().getProductType()) == null) {
            typeToItems.put(shoppingCartItem.getProduct().getProductType(), new ArrayList<>());
        }
        typeToItems.get(shoppingCartItem.getProduct().getProductType()).add(shoppingCartItem);
    }

    double calculatePrice() {
        double totalPrice = 0;


        for (ProductType productType : typeToItems.keySet()) {
            int quantity = 0;
            double price = 0;
            for (ShoppingCartItem shoppingCartItem : typeToItems.get(productType)) {
                quantity += shoppingCartItem.getQuantity();
                price += shoppingCartItem.getQuantity() * shoppingCartItem.getProduct().getPrice();
            }
            if (quantity > 2) {
                price *= 0.9;
            }
            totalPrice += price;
        }
        if (totalPrice > 100) {
            totalPrice *= 0.9;
        }
        return totalPrice;
    }
}
