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
        return "Welcome to STI Bakery";
    }

    public void printWelcomeMenu() {
        getWelcomeMessage();
        getAllProducts();
        options();
        getUserInput();
    }

    private void getUserInput() {
        while (running) {
            String userInput = createScanner().toLowerCase();
            processInput(userInput);
        }
    }

    String createScanner() {
        return scanner.nextLine();
    }

    public boolean processInput(String input) {
        return false;
    }





    public static List<Product> getAllProducts() {
        return new ArrayList<>(List.of(
                new Product("Chocolate Chip Cookie", "One chocolate chip cookie", "Cookies", 25.00, 1),
                new Product("Chocolate Cupcake", "Chocolate cupcake with cocoa nibs and sprinkles", "Cupcakes", 52.00, 1),
                new Product("Red Velvet Cupcake", "Red velvet cupcake with white cream frosting and red sprinkles", "Cupcakes", 52.00, 1),
                new Product("Lemon Cupcake", "Fresh lemon cupcake with white frosting and yellow lemon zest topping", "Cupcakes", 52.00, 1),
                new Product("Chocolate Cake", "8 piece cake with chocolate flavour", "Cakes", 475.00, 1),
                new Product("Macaron Cake", "12 piece vanilla flavoured cake with decorative macarons", "Cakes", 625.00, 1),
                new Product("Macaron Box Mix Small", "A box containing five macarons with different flavours", "Macarons", 60.00, 1),
                new Product("Macaron Box Mix Big", "A box containing 16 macarons with different flavours", "Macarons", 225.00, 1)
        ));
    }

    public String options() {
        return "What do you want to do next? \n" +
                "1) Add product to cart \n" +
                "2) Remove product from cart \n" +
                "3) View cart summary \n" +
                "4) Check saldo \n" +
                "5) Checkout";
    }


}
