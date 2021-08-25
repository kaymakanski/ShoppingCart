package com.company;

public class Main {

    public static void main(java.lang.String[] args) {
        Product product1 = new Product("1","Dell Laptop", 1300, ProductType.LAPTOP);
        Product product2 = new Product("2","HP Laptop", 1500, ProductType.LAPTOP);
        Product product3 = new Product("3","Logitech Headset", 180, ProductType.HEADPHONES);
        Product product4 = new Product("4", "Logitech Mouse", 160, ProductType.MOUSE);
        Inventory inventory = new Inventory();
        inventory.add(product1);
        inventory.add(product2);
        inventory.add(product3);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new LineProduct(product1.getId(), product1.getName(), 1, product1.getPrice()));
        cart.addProduct(new LineProduct(product2.getId(), product2.getName(), 4, product2.getPrice()));
        cart.addProduct(new LineProduct(product3.getId(), product3.getName(), 2, product3.getPrice()));
        cart.addProduct(new LineProduct(product4.getId(), product4.getName(), 3, product4.getPrice()));

        cart.showProductsInfo();
        cart.showProductsInfo();
    }
}
