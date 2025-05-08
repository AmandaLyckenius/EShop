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


    public String getWelcomeMessage() {
        return "Welcome to STI Bakery";
    }

    public void printWelcomeMenu(List<Product> allProducts) {
        System.out.println(getWelcomeMessage());
        showProducts(allProducts);
        System.out.println(options());
        getUserInput();
    }

    private void getUserInput() {
        while (running) {
            String userInput = createScannerString();
            processInput(userInput);
        }
    }

    int createScannerInt() {
        return scanner.nextInt();
    }

    String createScannerString() {
        return scanner.next();
    }

    public boolean processInput(String input) {
        return false;
    }



    public String options() {
        return "What do you want to do next? \n" +
                "1) Add product to cart \n" +
                "2) Remove product from cart \n" +
                "3) View cart summary \n" +
                "4) Check saldo \n" +
                "5) Checkout";
    }


    public void showProducts(List <Product> allProducts) {
        System.out.println("View our products below");

        for (Product product : allProducts) {
            System.out.println(product);
        }

    }


}
