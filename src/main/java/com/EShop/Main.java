package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;

import java.util.ArrayList;
import java.util.List;

import static com.EShop.ConsoleUI.getAllProducts;

public class Main {
    public static void main(String[] args) {

        List <Product> allProducts = getAllProducts();

        Discount discount10 = new TenPercent();
        Discount discount20 = new TwentyPercent();
        Product products = new Product();
        List<Product> productList = new ArrayList<>();
        Cart cart = new Cart(productList);
        ConsoleUI consoleUI = new ConsoleUI();

        products.showProducts(allProducts);

        // cart.showCart(discount20);
    }




}

