package com.EShop;

import java.util.List;
import java.util.Objects;

public class Product {
    int articleNumber;
    String article;
    String description;
    String category;
    double price;
    int quantity;

    public Product(int articleNumber, String article, String description, String category, double price, int quantity) {
        this.articleNumber=articleNumber;
        this.article = article;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
        this.articleNumber = articleNumber;
        this.article = article;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void showProducts(List <Product> allProducts) {
        System.out.println("View our products below");

        for (Product product : allProducts) {
            System.out.println(product);
        }

    }

    @Override
    public String toString() {
        return
                "\n" +
                article + "\n" + "Article number: " + articleNumber + "\n" + "Description: " + description + "\n" +
                "Price: " + price + " kr" + "\n" +
                "Quantity: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return  article.equals(product.article) &&
                description.equals(product.description) &&
                category.equals(product.category) &&
                price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, description, category, price);
    }
}
