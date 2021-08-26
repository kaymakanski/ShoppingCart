package com.company;

import com.company.products.Product;
import com.company.products.ProductType;
import com.company.shoppingCart.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingCartTest {

    private final Product product1 = new Product("1", "Dell Laptop", 80, ProductType.LAPTOP);
    private final Product product2 = new Product("2", "HP Laptop", 70, ProductType.LAPTOP);
    private final Product product3 = new Product("3", "Logitech Headset", 40, ProductType.HEADPHONES);
    private final Product product4 = new Product("4", "Logitech Mouse", 20, ProductType.MOUSE);
    private Inventory inventory;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        inventory.add(product1);
        inventory.add(product2);
        inventory.add(product3);
        inventory.add(product4);
        cart = new ShoppingCart();
    }

    @Test
    void addItemInCart() {
        cart.addItem(product3, 2);
        cart.addItem(product3, 3);
        cart.addItem(product4, 4);

        assertEquals(5, cart.getQuantity(product3));
        assertEquals(4, cart.getQuantity(product4));
        assertEquals(0, cart.getQuantity(product1));
    }

    @Test
    void deleteItemsInCart() {
        cart.addItem(product1, 1);
        cart.removeItem(product1);

        assertEquals(0, cart.getQuantity(product1));
    }

    @Test
    void decreaseQuantityOfItem() {
        cart.addItem(product1, 1);
        cart.addItem(product4, 4);

        cart.decreaseQuantity(product1, 1);
        cart.decreaseQuantity(product4, 3);

        assertEquals(0, cart.getQuantity(product1));
        assertEquals(1, cart.getQuantity(product4));
    }

    @Test
    void discountOverOneHundred() {
        cart.addItem(product1, 1);
        cart.addItem(product3, 1);

        assertEquals(108, cart.getTotalPrice());
    }

    @Test
    void discountForSameType() {
        cart.addItem(product4, 3);

        assertEquals(54, cart.getTotalPrice());
    }

    @Test
    void discountOverHundredAndSameType() {
        cart.addItem(product1, 2);
        cart.addItem(product2, 2);
        cart.addItem(product3, 2);

        assertEquals(315, cart.getTotalPrice());
    }

    @Test
    void removeMissingItem() {
        cart.addItem(product1, 1);
        assertThrows(ValidationException.class, () -> cart.decreaseQuantity(product2, 1), "Item not found in cart");
    }

    @Test
    void decreaseQuantityNegative() {
        cart.addItem(product1, 1);
        assertThrows(ValidationException.class, () -> cart.decreaseQuantity(product1, 2), "Quantity cannot be negative!");
    }
}