package com.EShop;

public class Customer {
    private double saldo;


    public Customer(double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(double saldo) {}

    public boolean deductSaldo(double amount){
        return true;
    }

    public double getSaldo() {
        return saldo;
    }

}
