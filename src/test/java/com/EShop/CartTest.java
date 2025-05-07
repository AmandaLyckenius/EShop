package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private List<Product> productList;
    Cart cart;
    Product laptop;
    Product tv;

    @BeforeEach
    void setUp(){
        productList = new ArrayList<>();
        cart = new Cart(productList);
        laptop = new Product(1,"Laptop", "Macbook", "Electronic", 10000.00, 1);
        tv = new Product(2,"TV","Samsung", "Electronic", 2000.00, 1);
    }

    @Test
    @DisplayName("Test adding a product to the Cart")
    void addToCart() {
        cart.addToCart(laptop);
        cart.addToCart( tv);
        assertTrue(cart.getProductList(productList).contains(laptop));
    }

    @Test
    @DisplayName("Test removing a product from the Cart")
    void removeFromCart() {
        cart.addToCart(laptop);
        cart.addToCart( tv);
        cart.removeFromCart(laptop);
        assertFalse(cart.getProductList(productList).contains(laptop));

    }

    @Test
    @DisplayName("Test showing  products in the Cart")
    void showCart() {
        cart.addToCart(laptop);
        cart.addToCart(laptop);
        cart.addToCart(tv);

        assertEquals(laptop, productList.get(0));
        assertEquals(laptop, productList.get(1));
        assertEquals(tv, productList.get(2));

    }

    @Test
    @DisplayName("Test calculating Cart's total amount before discount")
    void calculateTotalBeforeDiscount() {
        cart.addToCart(laptop);
        cart.addToCart(laptop);
        assertEquals(20000.00, cart.calculateTotalBeforeDiscount());
    }

    @Test
    @DisplayName("Test calculating Cart's total amount after discount")
    void calculateTotalAfterDiscount() {
        Discount discount10 = new TenPercent();
        cart.addToCart(laptop);
        cart.addToCart(laptop);
        assertEquals(18000.00, discount10.applyDiscount(cart.calculateTotalBeforeDiscount()));
    }
}