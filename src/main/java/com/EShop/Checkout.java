package com.EShop;

import com.EShop.cart.Cart;
import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;
import com.EShop.discount.TwentyPercent;

public class Checkout {
Customer customer;
Cart cart;
TenPercent tenPercent;
TwentyPercent twentyPercent;

    public Checkout(Customer customer, Cart cart, TenPercent tenPercent, TwentyPercent twentyPercent) {
        this.customer = customer;
        this.cart = cart;
        this.tenPercent = tenPercent;
        this.twentyPercent=twentyPercent;
    }

    public boolean pay(){
        double balance = customer.getBalance();

        double total = cart.calculateTotalAfterDiscount(tenPercent, twentyPercent);

        if (balance >= total){
            customer.setBalance(balance - total);
            return true;
        }

        return false;
    }


}
