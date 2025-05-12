package com.EShop.cart;

import com.EShop.product.Product;
import com.EShop.product.ProductService;

public class CartService {
    ProductService productService;
    CartItemCreator cartItemCreator;
    Cart cart;

    public CartService(ProductService productService, CartItemCreator cartItemCreator, Cart cart) {
        this.productService = productService;
        this.cartItemCreator = cartItemCreator;
        this.cart = cart;
    }

    public boolean addProductToCart_byArticleNumberAndQuantity(int articleNumber, int quantity){
        CartItem cartItem = cartItemCreator.createCartItem(articleNumber, quantity);

       if (cartItem != null){
           cart.addToCart(cartItem);
           return true;
       } else {
           return false;
       }

    }



}
