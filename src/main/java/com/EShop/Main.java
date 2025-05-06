package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", "Macbook","Electronic", 10000.00, 1);
        Product tv = new Product("TV", "Samsung","Electronic", 2000.00, 1);

        Discount discount10 = new TenPercent();
        Discount discount20 = new TwentyPercent();
        List<Product> productList = new ArrayList<>();

        Cart cart = new Cart(productList);

        cart.addToCart( laptop);
        cart.addToCart( tv);
        cart.addToCart( laptop);
        cart.removeFromCart(laptop);
        cart.removeFromCart(laptop);
        cart.removeFromCart(tv);




        cart.showCart(discount20);





    }
}
