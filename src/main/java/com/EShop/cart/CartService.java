package com.EShop.cart;

import com.EShop.product.Product;
import com.EShop.product.ProductService;

public class CartService {
    ProductService productService;
    CartItemCreator cartItemCreator;
    Cart cart;
    CartItem cartItem;

    public CartService(ProductService productService, CartItemCreator cartItemCreator, Cart cart) {
        this.productService = productService;
        this.cartItemCreator = cartItemCreator;
        this.cart = cart;
    }

    public boolean addProductToCart_byArticleNumberAndQuantity(int articleNumber, int quantity){
        cartItem = cartItemCreator.createCartItem(articleNumber, quantity);

       if (cartItem != null){
           cart.addToCart(cartItem);
           return true;
       } else {
           return false;
       }

    }

    public boolean removeProductFromCart_byArticleNumber(int articleNumber){
        for (CartItem item: cart.getCartItemList()){
            if (item.getProduct().getArticleNumber() == articleNumber){
                cart.removeFromCart(item);
                return true;
            }
        }
        return false;
    }

    public boolean productExists(int articleNumber) {
        return productService.getAllProducts().stream()
                .anyMatch(p -> p.getArticleNumber() == articleNumber);
    }




}
