package com.EShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CartItemCreatorTest {

    List<Product> productList;
    ProductService productService;
    CartItemCreator cartItemCreator;

    @BeforeEach
    public void setUp() {
        productList= new ArrayList<>(List.of(
                new Product(1,"Laptop", "Macbook", "Electronic", 10000.00),
                new Product(2,"TV","Samsung", "Electronic", 2000.00)

        ));

        productService = new ProductService(productList);
        cartItemCreator = new CartItemCreator(productService);
    }

    @Test
    public void createCartItemTest() {
        int fakeInput = 1;
        int fakeQuantity = 2;


        CartItem result = cartItemCreator.createCartItem(productService.findByArticleNumber(fakeInput), fakeQuantity);

        assertNotNull(result);
        assertEquals(productList.get(0).getArticleNumber(), result.getProduct().getArticleNumber());
        assertEquals(fakeQuantity, result.getQuantity());
    }
}
