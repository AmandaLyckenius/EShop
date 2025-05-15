package com.EShop.cart;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;
import com.EShop.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private List<CartItem> cartItemList;
    Cart cart;
    Product laptop;
    Product tv;
    Product bottle;
    CartItem laptopItem;
    CartItem tvItem;
    CartItem bottleItem;
    List<Discount> discounts;


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
        discounts = List.of(new TenPercent(), new TwentyPercent());

    }

    @Test
    @DisplayName("Test adding a product to the Cart")
    void addToCart() {
        cart.addToCart(laptopItem);
        assertTrue(cart.getCartItemList().contains(laptopItem));
    }

    @Test
    @DisplayName("Test removing a product from the Cart")
    void removeFromCart() {
        cart.addToCart(laptopItem);
        cart.addToCart(tvItem);
        cart.removeFromCart(laptopItem);
        assertFalse(cart.getCartItemList().contains(laptopItem));

    }

    @Test
    @DisplayName("Test calculating Cart's total amount before discount")
    void calculateTotalBeforeDiscount() {
        cart.addToCart(laptopItem);
        assertEquals(10000.00, cart.calculateTotalBeforeDiscount());

    }

    @Test
    @DisplayName("Test calculating Cart's total amount after 10 percent discount")
    void calculateTotalAfterDiscountIfTotalExceed100() {
        cart.addToCart(tvItem);
        double newTotal = cart.calculateTotalAfterDiscount(discounts);
        assertEquals(180.00, newTotal);
    }

    @Test
    @DisplayName("Test calculating Cart's total amount after 10 percent discount")
    void calculateTotalAfterDiscountIfTotalDoNotExceed100() {
        cart.addToCart(bottleItem);
        double newTotal = cart.calculateTotalAfterDiscount(discounts);
        assertEquals(80, newTotal);
    }

    @Test
    @DisplayName("Test calculating Cart's total amount after twenty percent discount")
    void calculateTotalAfterDiscountIfTotalExceed300() {
        cart.addToCart(laptopItem);
        double newTotal = cart.calculateTotalAfterDiscount(discounts);
        assertEquals(8000.00, newTotal);
    }
}