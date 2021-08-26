package com.company.shoppingCart;

import com.company.ValidationException;
import com.company.products.Product;

import java.util.*;

public class ShoppingCart {
    private final List<ShoppingCartItem> itemsInCart = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (quantity < 1) {
            throw new ValidationException("Quantity should be at least 1");
        }
        Optional<ShoppingCartItem> item = itemsInCart.stream().filter(i -> i.getProduct().equals(product)).findFirst();
        if (item.isPresent()) {
            item.get().modifyQuantity(quantity);
        } else {
            itemsInCart.add(new ShoppingCartItem(product, quantity));
        }
    }

    public void removeItem(Product productToRemove) {
        Optional<ShoppingCartItem> item = itemsInCart.stream().filter(i -> i.getProduct().equals(productToRemove)).findFirst();

        if (item.isPresent()) {
            itemsInCart.remove(item.get());
        }
    }

    public void decreaseQuantity(Product product, int quantity) {
        if (quantity < 1) {
            throw new ValidationException("Quantity should be at least 1");
        }
        Optional<ShoppingCartItem> item = itemsInCart.stream().filter(i -> i.getProduct().equals(product)).findFirst();
        if (item.isPresent()) {
            item.get().modifyQuantity(quantity * -1);
            if (item.get().getQuantity() == 0) {
                removeItem(product);
            }
        } else {
            throw new ValidationException("Item not found in cart");
        }
    }

    public double getTotalPrice() {
        return new PriceCalculator(this).calculatePrice();
    }

    public List<ShoppingCartItem> getItems() {
        return itemsInCart;
    }

    public int getQuantity(Product product) {
        Optional<ShoppingCartItem> item = itemsInCart.stream().filter(i -> i.getProduct().equals(product)).findFirst();

        if (item.isPresent()) {
            return item.get().getQuantity();
        }
        return 0;
    }
}
