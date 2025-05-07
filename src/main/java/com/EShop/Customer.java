package com.EShop;

public class Customer {
    private String name;
    private double saldo;

    private Cart cart;

    public Customer(String name, double saldo, Cart cart) {
        this.name = name;
        this.saldo = saldo;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
