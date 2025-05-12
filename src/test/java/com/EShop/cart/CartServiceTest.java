package com.EShop.cart;

import com.EShop.ConsoleUI;
import com.EShop.product.Product;
import com.EShop.product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    Product laptop;
    Product tv;
    List<Product> productList;
    ProductService productService;
    Cart cart;
    CartItemCreator cartItemCreator;
    ConsoleUI consoleUI;
    CartItem laptopItem;
    CartItem tvItem;
    CartService cartService;

    @BeforeEach
    public void setUp() {
        laptop = new Product(1,"Laptop", "Macbook", "Electronic", 10000.00);
        tv = new Product(2,"TV","Samsung", "Electronic", 2000.00);

        productList= new ArrayList<>();
        productList.add(laptop);
        productList.add(tv);

        productService = new ProductService(productList);
        cartItemCreator = new CartItemCreator(productService);

        laptopItem = new CartItem(laptop, 1);
        tvItem = new CartItem(tv, 1);
        cart = new Cart(new ArrayList<>());

        cartService = new CartService(productService, cartItemCreator, cart);
    }

    @Test
    void addProductToCart_byArticleNumberAndQuantityTest() {
        int fakeArticleNumber = 1;
        int fakeQuantity = 2;

        cartService.addProductToCart_byArticleNumberAndQuantity(1,2);

        CartItem itemInCart = cart.getCartItemList().get(0);

        assertEquals(laptop.getArticleNumber(), itemInCart.getProduct().getArticleNumber());
        assertEquals(2, itemInCart.getQuantity());

    }
}
