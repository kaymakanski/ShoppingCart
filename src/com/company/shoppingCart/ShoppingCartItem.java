package com.company.shoppingCart;

import com.company.ValidationException;
import com.company.products.Product;

public class ShoppingCartItem {
    private final Product product;
    private int quantity;

    ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void modifyQuantity(int quantity) {
        if (this.quantity < quantity * -1) {
            throw new ValidationException("Quantity cannot be negative!");
        }
        this.quantity += quantity;
    }
}
