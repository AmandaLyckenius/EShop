package com.EShop;
import com.EShop.cart.Cart;
import com.EShop.cart.CartItem;
import com.EShop.cart.CartItemCreator;
import com.EShop.cart.CartService;
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
    CartService cartService;
    Checkout checkout;
    List <Discount> discounts;
    Customer customer;
    List<Product> allProducts;

    public ConsoleUI(Cart cart, CartItemCreator cartItemCreator, ProductService productService, Checkout checkout, CartService cartService, List <Discount> discounts, Customer customer, List<Product> allProducts) {
        this.cart = cart;
        this.cartItemCreator = cartItemCreator;
        this.productService = productService;
        this.checkout = checkout;
        this.cartService = cartService;
        this.discounts=discounts;
        this.customer = customer;
        this.allProducts=allProducts;
    }

    public String getWelcomeMessage() {
        return "Welcome to STI Bakery";
    }

    public void start() {
        System.out.println(getWelcomeMessage());
        showProducts();
        System.out.println(options());
        getUserInput();
    }

    private void getUserInput() {
        while (running) {
            Integer userInput = promptForIntOrCancel("\nChoose an option from the menu ");

            if (userInput == null) {
                System.out.println("Thank you for visiting our webshop. Hope to see you soon again!");
                running = false;
                return;
            }
            processInput(userInput);
        }
    }

    public Integer promptForIntOrCancel(String prompt) {
        System.out.println(prompt + " (or type 'q' to cancel):");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("q")) {
            System.out.println("Action cancelled.");
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return promptForIntOrCancel(prompt);
        }
    }

    public boolean processInput(int input) {
        switch (input) {
            case 1 -> showProducts();
            case 2 -> handleAddToCart();
            case 3 -> handleRemoveFromCart();
            case 4 -> handleShowCart();
            case 5 -> handleCheckBalance();
            case 6 -> handleAddBalance();
            case 7 -> handleCheckout();
            default -> {
                System.out.println("Incorrect input");
                System.out.println(options());
            }
        }
        return false;
    }


    public String options() {
        return "\nWhat do you want to do next? \n" +
                "1) View products\n" +
                "2) Add product to cart \n" +
                "3) Remove product from cart \n" +
                "4) View cart summary \n" +
                "5) Check balance \n" +
                "6) Add balance \n" +
                "7) Checkout";
    }


    public void showProducts() {
        System.out.println("View our products below");

        for (Product product : allProducts) {
            System.out.println(product);
        }

    }

    public void handleShowCart() {
        if (cart.getCartItemList().isEmpty()) {
            System.out.println("Your cart is empty.");
            System.out.println(options());
            return;
        }

            System.out.println("You have following products in your cart:");

            for (CartItem cartItem : cart.getCartItemList()) {
                System.out.println(cartItem);
            }

            System.out.println("-----------------------------");

            double totalBefore = cart.calculateTotalBeforeDiscount();
            double totalAfter = cart.calculateTotalAfterDiscount(discounts);
            double discountAmount = totalBefore - totalAfter;
            System.out.printf("Total before discount: %.2f kr%n", totalBefore);
            System.out.printf("Discount applied: %.2f kr%n", discountAmount);
            System.out.printf("Total after discount: %.2f kr%n", totalAfter);

            System.out.println(options());

    }

    public void handleAddToCart() {
        while (true) {
            Integer articleNumber = promptForIntOrCancel("Enter article number ");
            if (articleNumber == null){
                System.out.println(options());
                return;
            }
            if (!cartService.productExists(articleNumber)) {
                System.out.println("Article number not found. Please try again.");
                continue;
            }
            Integer quantity = promptForIntOrCancel("Enter quantity ");
            if (quantity == null) {
                System.out.println(options());
                return;
            }

            boolean result = cartService.addProductToCart_byArticleNumberAndQuantity(articleNumber, quantity);

            if (result) {
                System.out.println("Product successfully added to cart!");
                break;
            }
        }
        System.out.println(options());
    }

    public void handleRemoveFromCart() {
        while (true) {
            Integer articleNumber = promptForIntOrCancel("Enter article number ");
            if (articleNumber == null){
                System.out.println(options());
                return;
            }

            if (!cart.containsArticleNumber(articleNumber)) {
                System.out.println("That product is not in your cart. Please try again.");
                continue;
            }
            cartService.removeProductFromCart_byArticleNumber(articleNumber);
            System.out.println("Product successfully removed from cart!");
            break;
        }
        System.out.println(options());
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
       System.out.println(options());
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
       System.out.println(options());
   }


    }