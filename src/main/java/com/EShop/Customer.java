package com.EShop;

import com.EShop.cart.Cart;

public class Customer {
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }

    public void addBalance(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        balance += amount;
    }

    public boolean deductBalance(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

}
