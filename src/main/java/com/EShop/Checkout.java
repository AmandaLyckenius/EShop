package com.EShop;

import com.EShop.cart.Cart;
import com.EShop.cart.CartItem;
import com.EShop.discount.Discount;

import java.util.List;

public class Checkout {
private final Customer customer;
private final Cart cart;
private final List<Discount> discounts;


    public Checkout(Customer customer, Cart cart, List <Discount> discounts) {
        this.customer = customer;
        this.cart = cart;
        this.discounts = discounts;
    }

    public boolean pay(){
        double balance = customer.getBalance();

        double total = cart.calculateTotalAfterDiscount(discounts);

        if (balance >= total){
            customer.deductBalance(total);
            cart.getCartItemList().clear();
            return true;
        }

        return false;
    }


}
