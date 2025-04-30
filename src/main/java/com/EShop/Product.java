package com.EShop;

public class Product {
    String article;
    String brand;
    String category;
    double price;
    int quantity;

    public Product(String article, String brand, String category, double price, int quantity) {
        this.article = article;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return (getPrice()* getQuantity());
    }

    @Override
    public String toString() {
        return
                "\n" +
                "Article:" + article + "\n" +
                "Brand:" + brand + "\n" +
                "Price:" + price + "\n" +
                "Quantity:" + quantity;
    }
}
