package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", "Macbook","Electronic", 10000.00, 1);
        Product tv = new Product("TV", "Samsung","Electronic", 2000.00, 1);

        Discount discount10 = new TenPercent();
        List<Product> productList = new ArrayList<>();

        Cart cart = new Cart(productList);

        cart.addToCart( laptop);
        cart.addToCart( tv);

        cart.showCart();
        System.out.println("Total amount before discount: " + cart.calculateTotalBeforeDiscount() + "kr");
        System.out.println("Total amount after discount: " + cart.calculateTotalAfterDiscount(discount10) + "kr");

    }
}
