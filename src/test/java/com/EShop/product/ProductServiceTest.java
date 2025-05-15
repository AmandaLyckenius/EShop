package com.EShop.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private List <Product> productList;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productList= new ArrayList<>(List.of(
                new Product(1,"Laptop", "Macbook", "Electronic", 10000.00),
                new Product(2,"TV","Samsung", "Electronic", 2000.00)

        ));

        productService = new ProductService(productList);
    }

    @Test
    public void findByArticleNumberTest() {
        int fakeUserInput = 1;
        assertEquals(productList.get(0), productService.findByArticleNumber(fakeUserInput) );
    }

    @Test
    public void findByArticleNumber_returnsNull_whenArticleNumberDoesNotExist(){
        int fakeUserInput = 999;
        assertNull(productService.findByArticleNumber(fakeUserInput));
    }
}
