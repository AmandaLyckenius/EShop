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
    Customer customer;

    public ConsoleUI(Cart cart, CartItemCreator cartItemCreator, ProductService productService, Checkout checkout, CartService cartService, TenPercent tenPercent, TwentyPercent twentyPercent, Customer customer) {
        this.cart = cart;
        this.cartItemCreator = cartItemCreator;
        this.productService = productService;
        this.checkout = checkout;
        this.cartService = cartService;
        this.tenPercent = tenPercent;
        this.twentyPercent = twentyPercent;
        this.customer = customer;
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
            scanner.nextLine();
            processInput(userInput);
        }
    }

    public Integer promptForIntOrCancel(String prompt) {
        System.out.println(prompt + " (or type 'q' to cancel):");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("q")) {
            System.out.println("Action cancelled.");
            System.out.println("What do you want to do next?");
            return null;
        }

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
            case 4 -> handleCheckBalance();
            case 5 -> handleAddBalance();
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


    public void showProducts(List<Product> allProducts) {
        System.out.println("View our products below");

        for (Product product : allProducts) {
            System.out.println(product);
        }

    }

    public void handleShowCart() {
        if (cart.getCartItemList().isEmpty()) {
            System.out.println("Your cart is empty.");
            System.out.println("What do you want to do next?");
            return;
        } 


            System.out.println("You have following products in your cart:");
            for (CartItem cartItem : cart.getCartItemList()) {
                System.out.println(cartItem);
            }

            System.out.println("-----------------------------");

            double totalBefore = cart.calculateTotalBeforeDiscount();
            double totalAfter = cart.calculateTotalAfterDiscount(tenPercent, twentyPercent);
            double discountAmount = totalBefore - totalAfter;
                System.out.printf("Total before discount: %.2f kr%n", totalBefore);
                System.out.printf("Discount applied: %.2f kr%n", discountAmount);
                System.out.printf("Total after discount: %.2f kr%n", totalAfter);
            System.out.println("What do you want to do next?");

    }

    public void handleAddToCart() {
        while (true) {
            Integer articleNumber = promptForIntOrCancel("Enter article number ");
            if (articleNumber == null) return;
            if (!cartService.productExists(articleNumber)) {
                System.out.println("Article number not found. Please try again.");
                continue;
            }
            Integer quantity = promptForIntOrCancel("Enter quantity ");
            if (quantity == null) return;

            boolean result = cartService.addProductToCart_byArticleNumberAndQuantity(articleNumber, quantity);

            if (result) {
                System.out.println("Product successfully added to cart!");
                break;
            }
        }
        System.out.println("What do you want to do next?");
    }

    public void handleRemoveFromCart() {
        while (true) {
            Integer articleNumber = promptForIntOrCancel("Enter article number ");
            if (articleNumber == null) return;

            if (!cart.containsArticleNumber(articleNumber)) {
                System.out.println("That product is not in your cart. Please try again.");
                continue;
            }
            cartService.removeProductFromCart_byArticleNumber(articleNumber);
            System.out.println("Product successfully removed from cart!");
            break;
        }
        System.out.println("What do you want to do next?");
    }



    public void handleCheckout() {

        boolean checkoutSum = checkout.pay();

        if (checkoutSum){
            System.out.println("Payment successful! Thank you for shopping with us.");
        }
        else {
            System.out.println("Not enough balance to complete your purchase.");
            System.out.println("Please select option 5 from the menu to add more balance.");
        }

    }

   public void handleCheckBalance() {
       System.out.printf("Your current balance is: %.2f kr%n", customer.getBalance());
       System.out.println("What do you want to do next?");
   }

   public void handleAddBalance() {
       System.out.println("Enter amount to add (or type 'q' to cancel):");
       String input = scanner.nextLine();

       if (input.equalsIgnoreCase("q")) {
           System.out.println("Action cancelled.");
       }
       else {
           try {
               double amount = Double.parseDouble(input);
               customer.addBalance(amount);
               System.out.printf("%.2f kr has been added to your balance.%n", amount);
               System.out.printf("New balance: %.2f kr%n", customer.getBalance());
           } catch (NumberFormatException e) {
               System.out.println("Invalid input. Please enter a number.");
           } catch (IllegalArgumentException e) {
               System.out.println(e.getMessage());
           }
       }
       System.out.println("What do you want to do next?");
   }


    }