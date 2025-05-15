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

    private Product laptop;
    private Cart cart;
    private ConsoleUI consoleUI;
    private CartService cartService;

    @BeforeEach
    public void setUp() {
        laptop = new Product(1,"Laptop", "Macbook", "Electronic", 10000.00);
        Product tv = new Product(2, "TV", "Samsung", "Electronic", 2000.00);

        List<Product> productList = new ArrayList<>();
        productList.add(laptop);
        productList.add(tv);

        ProductService productService = new ProductService(productList);
        CartItemCreator cartItemCreator = new CartItemCreator(productService);

        CartItem laptopItem = new CartItem(laptop, 1);
        CartItem tvItem = new CartItem(tv, 1);
        cart = new Cart(new ArrayList<>());

        cartService = new CartService(productService, cartItemCreator, cart);
    }

    @Test
    void addProductToCart_byArticleNumberAndQuantityTest() {
        int fakeArticleNumber = 1;
        int fakeQuantity = 2;

        cartService.addProductToCart_byArticleNumberAndQuantity(fakeArticleNumber,fakeQuantity);

        CartItem itemInCart = cart.getCartItemList().get(0);

        assertEquals(laptop.getArticleNumber(), itemInCart.getProduct().getArticleNumber());
        assertEquals(2, itemInCart.getQuantity());

    }

    @Test
    void removeProductFromCart_decreaseQuantity_ifQuantityMoreThan1() {
        int fakeArticleNumber = 1;
        int fakeQuantity = 2;

        cartService.addProductToCart_byArticleNumberAndQuantity(fakeArticleNumber,fakeQuantity);

        CartItem itemFromCart = cart.getCartItemList().get(0);
        cartService.removeProductFromCart_byArticleNumber(fakeArticleNumber);

        assertEquals(1, itemFromCart.getQuantity());
        assertTrue(cart.getCartItemList().contains(itemFromCart));
    }

    @Test
    void removeProductFromCart_removesCompletely_whenQuantityIsOne() {
        int fakeArticleNumber = 1;
        int fakeQuantity = 1;

        cartService.addProductToCart_byArticleNumberAndQuantity(fakeArticleNumber,fakeQuantity);

        CartItem itemFromCart = cart.getCartItemList().get(0);
        cartService.removeProductFromCart_byArticleNumber(fakeArticleNumber);

        assertFalse(cart.getCartItemList().contains(itemFromCart));

    }
}
