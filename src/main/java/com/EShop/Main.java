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

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List <Product> allProducts = getAllProducts();
        Discount discount10 = new TenPercent();
        Discount discount20 = new TwentyPercent();
        List<CartItem> cartItemList = new ArrayList<>();
        Cart cart = new Cart(cartItemList);
        ProductService productService = new ProductService(allProducts);
        CartItemCreator cartItemCreator = new CartItemCreator(productService);
        Customer customer = new Customer(10);
        TenPercent tenPercent = new TenPercent();
        TwentyPercent twentyPercent = new TwentyPercent();
        CartService cartService = new CartService(productService, cartItemCreator, cart);
        Checkout checkout = new Checkout(customer, cart, tenPercent, twentyPercent);
        ConsoleUI consoleUI = new ConsoleUI(cart,cartItemCreator,productService,checkout, cartService, tenPercent, twentyPercent, customer, allProducts);

        consoleUI.start();



    }

    public static List<Product> getAllProducts() {
        return new ArrayList<>(List.of(
                new Product(1,"Chocolate Chip Cookie", "One chocolate chip cookie", "Cookies", 25.00),
                new Product(2,"Chocolate Cupcake", "Chocolate cupcake with cocoa nibs and sprinkles", "Cupcakes", 52.00),
                new Product(3,"Red Velvet Cupcake", "Red velvet cupcake with white cream frosting and red sprinkles", "Cupcakes", 52.00),
                new Product(4,"Lemon Cupcake", "Fresh lemon cupcake with white frosting and yellow lemon zest topping", "Cupcakes", 52.00),
                new Product(5,"Chocolate Cake", "8 piece cake with chocolate flavour", "Cakes", 475.00),
                new Product(6,"Macaron Cake", "12 piece vanilla flavoured cake with decorative macarons", "Cakes", 625.00),
                new Product(7,"Macaron Box Mix Small", "A box containing five macarons with different flavours", "Macarons", 60.00),
                new Product(8,"Macaron Box Mix Big", "A box containing 16 macarons with different flavours", "Macarons", 225.00)
        ));
    }




}

