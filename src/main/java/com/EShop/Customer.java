package com.EShop;

public class Customer {
    private double saldo;


    public Customer(double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        saldo += amount;
    }

    public boolean deductSaldo(double amount) {
        if (amount > 0 && amount <= saldo) {
            saldo -= amount;
            return true;
        }
        return false;
    }


    public double getSaldo() {
        return saldo;
    }

}
