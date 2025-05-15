package com.EShop.cart;

import com.EShop.discount.Discount;

import java.util.List;

public class Cart {

    private List <CartItem> cartItemList;

    public Cart(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void addToCart(CartItem cartItem) {
        for (CartItem c : cartItemList) {
            if (c.equals(cartItem)) {
                c.setQuantity(c.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
        cartItemList.add(cartItem);
    }

    public void removeFromCart(CartItem cartItem){
        for (CartItem c : cartItemList) {
            if (c.equals(cartItem)) {
                if (c.getQuantity() >= 2) {
                    c.setQuantity(c.getQuantity() - 1);
                } else {
                    cartItemList.remove(c);
                }
                return;
            }
        }

    }


    public double calculateTotalBeforeDiscount() {
        double total = 0;
        for (CartItem cartItem : cartItemList) {
            total += cartItem.calculateTotal();
        }
        return total;
    }

    public double calculateTotalAfterDiscount(List<Discount> discounts) {
        double total = calculateTotalBeforeDiscount();

        for (Discount discount: discounts){
            if (discount.isApplicable(total)){
                total = discount.applyDiscount(total);
                break;
            }

        }
        return total;
    }

    public boolean containsArticleNumber(int articleNumber) {
        return cartItemList.stream()
                .anyMatch(item -> item.getProduct().getArticleNumber() == articleNumber);
    }

}
