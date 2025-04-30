package com.EShop;

import com.EShop.discount.Discount;
import com.EShop.discount.TenPercent;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List <Product> productList;

    public Cart(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList(List<Product> productList) {
        return productList;
    }

    public List<Product> addToCart(Product product){
       productList.add(product);
       return productList;
    }

    public List<Product> removeFromCart( Product product){
        productList.remove(product);
        return productList;

    }

    public void showCart() {
        System.out.println("You have following products in your cart:");
        for (Product product: getProductList(productList) ){
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

    public double calculateTotalAfterDiscount (Discount discount) {
        return discount.applyDiscount(calculateTotalBeforeDiscount());
    }


}
