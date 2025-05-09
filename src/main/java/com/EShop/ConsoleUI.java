package com.EShop;
import com.EShop.cart.Cart;
import com.EShop.cart.CartItem;
import com.EShop.cart.CartItemCreator;
import com.EShop.discount.Discount;
import com.EShop.product.Product;
import com.EShop.product.ProductService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private boolean running = true;
    private final Scanner scanner = new Scanner(System.in);
    Cart cart;
    CartItemCreator cartItemCreator;
    ProductService productService;

    public ConsoleUI(Cart cart, CartItemCreator cartItemCreator, ProductService productService) {
        this.cart = cart;
        this.cartItemCreator = cartItemCreator;
        this.productService = productService;
    }

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

    public void showCart(Discount discount) {
        if (cart.getCartItemList().isEmpty()) {
            System.out.println("You don't have any articles in your cart");
        } else {
            System.out.println("You have following products in your cart:");
            for (CartItem cartItem: cart.getCartItemList() ){
                System.out.println(cartItem);
            }

            System.out.println("-----------------------------");

            double totalBefore = cart.calculateTotalBeforeDiscount();
            System.out.println("Total amount before discount: " + totalBefore);
            System.out.println("Discount amount: " + discount.discountAmount(totalBefore));
            System.out.println("Total amount after discount: " + discount.applyDiscount(totalBefore));
        }
    }


}
