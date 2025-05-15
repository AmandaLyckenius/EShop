package com.EShop.cart;

import com.EShop.product.ProductService;

public class CartService {
    private final ProductService productService;
    private final CartItemCreator cartItemCreator;
    private final Cart cart;

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

    public void removeProductFromCart_byArticleNumber(int articleNumber){
        for (CartItem item: cart.getCartItemList()){
            if (item.getProduct().getArticleNumber() == articleNumber){
                cart.removeFromCart(item);
                return;
            }
        }
    }

    public boolean productExists(int articleNumber) {
        return productService.getAllProducts().stream()
                .anyMatch(p -> p.getArticleNumber() == articleNumber);
    }




}
