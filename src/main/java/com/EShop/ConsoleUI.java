package com.EShop;
import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private boolean running = true;
    private final Scanner scanner = new Scanner(System.in);
    Discount discount10 = new TenPercent();
    Discount discount20 = new TwentyPercent();
    Product products = new Product();
    List<Product> productList = new ArrayList<>();
    Cart cart = new Cart(productList);
    List <Product> allProducts = getAllProducts();

    public String getWelcomeMessage() {
        return "";
    }
    public void printWelcomeMenu() {
    }

    public static List<Product> getAllProducts() {
        return new ArrayList<>(List.of(
        ));
    }

    public String options() {
        return "";
    }

    boolean processInput(String input) {
        return false;
    }


}
