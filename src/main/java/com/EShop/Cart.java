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

    public List<Product> addToCart(Product product) {
        for (Product p : productList) {
            if (p.equals(product)) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                return productList;
            }
        }
        productList.add(product);
        return productList;
    }

    public List<Product> removeFromCart( Product product){
        for (Product p : productList) {
            if (p.equals(product)) {

                if (p.getQuantity() >= 2) {
                    p.setQuantity(p.getQuantity() - 1);
                    return productList;
                }

            }
        }
        productList.remove(product);
        return productList;

    }

    public void showCart(Discount discount) {
        if (productList.isEmpty()) {
            System.out.println("You don't have any articles in your cart");
        } else {
            System.out.println("You have following products in your cart:");
            for (Product product: getProductList(productList) ){
                System.out.println(product);
            }

            System.out.println("-----------------------------");
            System.out.println("Total amount before discount: " + calculateTotalBeforeDiscount());
            System.out.println("Discount amount: " + discount.discountAmount(calculateTotalBeforeDiscount()));
            System.out.println("Total amount after discount: " + discount.applyDiscount(calculateTotalBeforeDiscount()));


        }


    }

    public double calculateTotalBeforeDiscount() {
        double total = 0;
        for (Product product : productList) {
            total += product.calculateTotal();
        }
        return total;
    }







}
