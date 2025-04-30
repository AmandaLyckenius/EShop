package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Product laptop = new Product("Macbook", "Electronic", 10000.00, 1);
        Product tv = new Product("Samsung", "Electronic", 2000.00, 1);

        Discount discount = new TenPercent();

        Cart cart = new Cart();

        cart.addToCart(laptop);
        cart.addToCart(tv);

        cart.showCart();
        System.out.println(cart.calculateTotalBeforeDiscount());
        System.out.println(cart.calculateTotalAfterDiscount());

    }
}
