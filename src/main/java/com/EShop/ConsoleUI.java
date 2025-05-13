package com.EShop;
import com.EShop.cart.Cart;
import com.EShop.cart.CartItem;
import com.EShop.cart.CartItemCreator;
import com.EShop.cart.CartService;
import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;
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
    CartService cartService;
    Checkout checkout;
    TenPercent tenPercent;
    TwentyPercent twentyPercent;

    public ConsoleUI(Cart cart, CartItemCreator cartItemCreator, ProductService productService, Checkout checkout, CartService cartService, TenPercent tenPercent, TwentyPercent twentyPercent) {
        this.cart = cart;
        this.cartItemCreator = cartItemCreator;
        this.productService = productService;
        this.checkout=checkout;
        this.cartService=cartService;
        this.tenPercent=tenPercent;
        this.twentyPercent=twentyPercent;
    }

    public String getWelcomeMessage() {
        return "Welcome to STI Bakery";
    }

    public void start(List<Product> allProducts) {
        System.out.println(getWelcomeMessage());
        showProducts(allProducts);
        System.out.println(options());
        getUserInput();
    }

    private void getUserInput() {
        while (running) {
            int userInput = createScannerInt();
            processInput(userInput);
        }
    }

    public Integer promptForIntOrCancel(String prompt) {
        System.out.println(prompt + " (or type 'q' to cancel):");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("q")) return null;

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return promptForIntOrCancel(prompt);
        }
    }

    String createScannerString() {
        return scanner.next();
    }

    int createScannerInt() {
        return scanner.nextInt();
    }



    public boolean processInput(int input) {
        switch (input) {
            case 1 -> handleAddToCart();
            case 2 -> handleRemoveFromCart();
            case 3 -> handleShowCart();
            case 6 -> handleCheckout();
        }
        return false;
    }



    public String options() {
        return "What do you want to do next? \n" +
                "1) Add product to cart \n" +
                "2) Remove product from cart \n" +
                "3) View cart summary \n" +
                "4) Check balance \n" +
                "5) Add balance \n" +
                "6) Checkout";
    }


    public void showProducts(List <Product> allProducts) {
        System.out.println("View our products below");

        for (Product product : allProducts) {
            System.out.println(product);
        }

    }

    public void handleShowCart() {
        if (cart.getCartItemList().isEmpty()) {
            System.out.println("You don't have any articles in your cart. What do you want to do next?");
            return;
        } else {
            System.out.println("You have following products in your cart:");
            for (CartItem cartItem: cart.getCartItemList() ){
                System.out.println(cartItem);
            }

            System.out.println("-----------------------------");

            double totalBefore = cart.calculateTotalBeforeDiscount();
            double totalAfter = cart.calculateTotalAfterDiscount(tenPercent, twentyPercent);
            System.out.println("Total amount before discount: " + totalBefore);
            System.out.println("Discount amount: " + (totalBefore-totalAfter));
            System.out.println("Total amount after discount: " + totalAfter);
        }
    }

    public void handleAddToCart() {
        boolean addedSuccessfully = false;

        while (!addedSuccessfully) {
            Integer articleNumber = promptForIntOrCancel("Enter article number ");
            if (articleNumber == null) return;
            Integer quantity = promptForIntOrCancel("Enter quantity ");
            if (quantity == null) return;

            boolean result = cartService.addProductToCart_byArticleNumberAndQuantity(articleNumber, quantity);

            if (result == true){
                System.out.println("Product successfully added to cart!");
                addedSuccessfully = true;
            } else {
                System.out.println("Product could not be added to cart. Please try again!");
            }
        }
    }

    public void handleRemoveFromCart() {
        boolean removedSuccessfully = false;

        while (!removedSuccessfully) {
            Integer articleNumber = promptForIntOrCancel("Enter article number ");
            if (articleNumber == null) return;

            boolean result = cartService.removeProductFromCart_byArticleNumber(articleNumber);

            if (result == true){
                System.out.println("Product successfully removed from cart!");
                removedSuccessfully = true;
            } else {
                System.out.println("Product could not be removed from cart. Please try again!");
            }
        }

    }

    public void handleCheckout() {

        boolean checkoutSum = checkout.pay();

        if (checkoutSum){
            System.out.println("Success!");
        }
        if (!checkoutSum){
            System.out.println("Not enough money, add more balance to checkout");
        }

    }


}
