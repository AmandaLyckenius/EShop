package com.EShop.product;

import java.util.List;

public class ProductService {

    private final List<Product> allProducts;

    public ProductService(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public Product findByArticleNumber (int articleNumber) {

        for(Product product: allProducts) {
            if (articleNumber == product.getArticleNumber()){
                return product;
            }

        }

        return null;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

}
