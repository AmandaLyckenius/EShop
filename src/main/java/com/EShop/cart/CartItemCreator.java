package com.EShop.cart;

import com.EShop.product.Product;
import com.EShop.product.ProductService;

public class CartItemCreator {
   private final ProductService productService;

    public CartItemCreator(ProductService productService) {
        this.productService = productService;
    }

    public CartItem createCartItem(int articleNumber, int quantity) {
        Product result = productService.findByArticleNumber(articleNumber);

        if (result != null && quantity>0) {
            CartItem cartItem = new CartItem(result,quantity);
            return cartItem;
        }

        return null;

    }

}
