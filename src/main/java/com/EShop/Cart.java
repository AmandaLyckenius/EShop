package com.EShop;
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

    public List<CartItem> addToCart(CartItem cartItem) {
        for (CartItem c : cartItemList) {
            if (c.equals(cartItem)) {
                c.setQuantity(c.getQuantity() + cartItem.getQuantity());
                return cartItemList;
            }
        }
        cartItemList.add(cartItem);
        System.out.println(cartItem.getProduct().article + " successfully added to the cart" + "\n");
        return cartItemList;
    }

    public List<CartItem> removeFromCart(CartItem cartItem){
        for (CartItem c : cartItemList) {
            if (c.equals(cartItem)) {

                if (c.getQuantity() >= 2) {
                    c.setQuantity(c.getQuantity() - 1);
                    return cartItemList;
                }

            }
        }
        cartItemList.remove(cartItem);
        System.out.println(cartItem.getProduct().article + " successfully removed from the cart" + "\n");
        return cartItemList;

    }


    public double calculateTotalBeforeDiscount() {
        double total = 0;
        for (CartItem cartItem : cartItemList) {
            total += cartItem.calculateTotal();
        }
        return total;
    }







}
