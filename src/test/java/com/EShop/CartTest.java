package com.EShop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private List<Product> productList;

    @Test
    @DisplayName("Test adding a product to the Cart")
    void addToCart() {
        Cart cart = new Cart();
        Product laptop = new Product("Macbook", "Electronic", 10000.00, 1);
        Product tv = new Product("Samsung", "Electronic", 2000.00, 1);
        cart.addToCart(laptop);
        cart.addToCart(tv);
        assertTrue(cart.getProductList().contains(laptop));
    }

    @Test
    @DisplayName("Test removing a product from the Cart")
    void removeFromCart() {
        Cart cart = new Cart();
        Product laptop = new Product("Macbook", "Electronic", 10000.00, 1);
        Product tv = new Product("Samsung", "Electronic", 2000.00, 1);
        cart.addToCart(laptop);
        cart.addToCart(tv);
        cart.removeFromCart(laptop);
        assertFalse(cart.getProductList().contains(laptop));

    }

    @Test
    @DisplayName("Test showing  products in the Cart")
    void showCart() {
        Cart cart = new Cart();
        Product laptop = new Product("Macbook", "Electronic", 10000.00, 1);
        Product tv = new Product("Samsung", "Electronic", 2000.00, 3);
        cart.addToCart(laptop);
        cart.addToCart(laptop);
        cart.addToCart(tv);
    }

    @Test
    @DisplayName("Test calculating Cart's total amount before discount")
    void calculateTotalBeforeDiscount() {
        Cart cart = new Cart();
        Product laptop = new Product("Macbook", "Electronic", 10000.00, 1);
        cart.addToCart(laptop);
        cart.addToCart(laptop);
        assertEquals(20000.00, cart.calculateTotalBeforeDiscount());
    }

    @Test
    @DisplayName("Test calculating Cart's total amount after discount")
    void calculateTotalAfterDiscount() {
        Cart cart = new Cart();
        Product laptop = new Product("Macbook", "Electronic", 10000.00, 1);
        cart.addToCart(laptop);
        cart.addToCart(laptop);
        assertEquals(18000.00, cart.calculateTotalAfterDiscount());
    }
}