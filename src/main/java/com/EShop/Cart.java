package com.EShop;

import com.EShop.discount.Discount;

import java.util.List;

public class Cart {
    private List<Product> product;
    Discount discount;

    public Cart(List<Product> product, Discount discount) {
        this.product = product;
        this.discount = discount;
    }
}
