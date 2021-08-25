package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private Inventory inventory;
    private ShoppingCart cart;
    private final Product product1 = new Product("1","Dell Laptop", 1300, ProductType.LAPTOP);
    private final Product product2 = new Product("2","HP Laptop", 1500, ProductType.LAPTOP);
    private final Product product3 = new Product("3","Logitech Headset", 180, ProductType.HEADPHONES);
    private final Product product4 = new Product("4", "Logitech Mouse", 160, ProductType.MOUSE);

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
    void should_add_a_Product() {
        cart.addProduct(new LineProduct(product1.getId(), product1.getName(), 1, product1.getPrice()));
        cart.addProduct(new LineProduct(product2.getId(), product2.getName(), 3, product2.getPrice()));

        assertEquals(4, cart.getTotalNumberOfProducts());
    }

    @Test
    void should_delete_specific_quantity_of_a_Product() {
        cart.addProduct(new LineProduct(product1.getId(), product1.getName(), 4, product1.getPrice()));
        cart.addProduct(new LineProduct(product2.getId(), product2.getName(), 3, product2.getPrice()));

        cart.deleteProduct(new LineProduct(product1.getId(), 2));
        cart.deleteProduct(new LineProduct(product2.getId(), 1));
        assertEquals(4, cart.getTotalNumberOfProducts());
    }

    @Test
    void should_get_the_total_price(){
        cart.addProduct(new LineProduct(product1.getId(), product1.getName(), 1, product1.getPrice()));
        cart.addProduct(new LineProduct(product2.getId(), product2.getName(), 1, product2.getPrice()));

        assertEquals(2520, cart.getTotalPrice());
    }

    @Test
    void should_get_the_total_price_with_a_discounted_product(){
        cart.addProduct(new LineProduct(product1.getId(), product1.getName(), 3, product1.getPrice()));
        cart.addProduct(new LineProduct(product2.getId(), product2.getName(), 1, product2.getPrice()));

        assertEquals(4509, cart.getTotalPrice());
    }

    @Test
    void should_get_the_total_discount(){
        cart.addProduct(new LineProduct(product1.getId(), product1.getName(), 3, product1.getPrice()));
        cart.addProduct(new LineProduct(product2.getId(), product2.getName(), 1, product2.getPrice()));

        assertEquals(5400-4509, cart.getTotalDiscount(cart.getTotalPrice()));
    }
}