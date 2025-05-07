package com.EShop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.EShop.Main.getAllProducts;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {

    @Test
    void getWelcomeMessageTest() {
        ConsoleUI consoleUI = new ConsoleUI();
        String welcomeMessage = consoleUI.getWelcomeMessage();
        assertEquals("Welcome to STI Bakery", welcomeMessage);
    }

    @Test
    void getAllProductsTest(){
        ConsoleUI consoleUI = new ConsoleUI();
        List<Product> allProducts = getAllProducts();
        assertEquals(8, allProducts.size());
        assertEquals("Chocolate Chip Cookie", allProducts.get(0).getArticle());

    }

    @Test
    void options() {
        ConsoleUI consoleUI = new ConsoleUI();
        String options = consoleUI.options();
        assertEquals("What do you want to do next? \n" +
                "1) Add product to cart \n" +
                "2) Remove product from cart \n" +
                "3) View cart summary \n" +
                "4) Check saldo \n" +
                "5) Checkout", options);
    }


    @Test
    void processInput() {
        ConsoleUI consoleUI = new ConsoleUI();

    }
}