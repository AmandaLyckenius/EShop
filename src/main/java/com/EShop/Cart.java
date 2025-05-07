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

    public void showCart(Discount discount) {
        if (cartItemList.isEmpty()) {
            System.out.println("You don't have any articles in your cart");
        } else {
            System.out.println("You have following products in your cart:");
            for (CartItem cartItem: cartItemList ){
                System.out.println(cartItem);
            }

            System.out.println("-----------------------------");

            double totalBefore = calculateTotalBeforeDiscount();
            System.out.println("Total amount before discount: " + totalBefore);
            System.out.println("Discount amount: " + discount.discountAmount(totalBefore));
            System.out.println("Total amount after discount: " + discount.applyDiscount(totalBefore));
        }
    }

    public double calculateTotalBeforeDiscount() {
        double total = 0;
        for (CartItem cartItem : cartItemList) {
            total += cartItem.calculateTotal();
        }
        return total;
    }







}
