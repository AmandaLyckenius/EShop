package com.EShop;

import com.EShop.cart.Cart;
import com.EShop.cart.CartItem;
import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;
import com.EShop.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {
    Customer customer;
    Cart cart;
    private List<CartItem> cartItemList;
    Product laptop;
    Product tv;
    Product bottle;
    CartItem laptopItem;
    CartItem tvItem;
    CartItem bottleItem;
    TenPercent tenPercent;
    TwentyPercent twentyPercent;
    Checkout checkout;
    double fakeBalance;

    @BeforeEach
    void setUp() {
        cartItemList = new ArrayList<>();
        cart = new Cart(cartItemList);
        laptop = new Product(1, "Laptop", "Macbook", "Electronic", 10000.00);
        tv = new Product(2, "TV", "Samsung", "Electronic", 200.00);
        bottle = new Product (3, "Bottle", "Samsung", "Electronic", 80.00);
        laptopItem = new CartItem(laptop, 1);
        tvItem = new CartItem(tv, 1);
        bottleItem = new CartItem(bottle, 1);
        tenPercent = new TenPercent();
        twentyPercent = new TwentyPercent();
        fakeBalance = 500;
        customer = new Customer(fakeBalance);
        checkout = new Checkout(customer, cart, tenPercent, twentyPercent);
    }

    @Test
    void testPaySucceedsWhenBalanceIsEnough() {
        cart.addToCart(tvItem);

        boolean isBalanceEnough = checkout.pay();

        assertEquals(320, customer.getBalance());
        assertTrue(isBalanceEnough);
    }

    @Test
    void testPaySucceedsWhenBalanceIsNotEnough(){
        cart.addToCart(laptopItem);

        boolean isBalanceEnough = checkout.pay();

        assertEquals(500, customer.getBalance());
        assertFalse(isBalanceEnough);
    }
}