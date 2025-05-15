package com.EShop;

import com.EShop.cart.Cart;
import com.EShop.discount.Discount;

import java.util.List;

public class Checkout {
Customer customer;
Cart cart;
List<Discount> discounts;

    public Checkout(Customer customer, Cart cart, List <Discount> discounts) {
        this.customer = customer;
        this.cart = cart;
        this.discounts = discounts;
    }

    public boolean pay(){
        double balance = customer.getBalance();

        double total = cart.calculateTotalAfterDiscount(discounts);

        if (balance >= total){
            customer.setBalance(balance - total);
            return true;
        }

        return false;
    }


}
