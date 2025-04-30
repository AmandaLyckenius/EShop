package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productList;
    Discount discount;
    TenPercent tenPercent = new TenPercent();

    public Cart(List<Product> productList, Discount discount) {
        this.productList = new ArrayList<>(productList);
        this.discount = discount;
    }

    public Cart() {
        this.productList = new ArrayList<>();
        this.discount = null;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> addToCart(Product product){
       productList.add(product);
       return productList;
    }

    public List<Product> removeFromCart(Product product){
        productList.remove(product);
        return productList;

    }

    public void showCart() {
        System.out.println("Cart:");
        for (Product product: getProductList() ){
            System.out.println(product);
        }
    }

    public double calculateTotalBeforeDiscount() {
        double total = 0;
        for (Product product : productList) {
            total += product.calculateTotal();
        }
        return total;
    }

    public double calculateTotalAfterDiscount() {
        return tenPercent.applyDiscount(calculateTotalBeforeDiscount());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "discount=" + discount +
                ", productList=" + productList +
                '}';
    }
}
