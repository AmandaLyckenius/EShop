package com.EShop.product;

import java.util.Objects;

public class Product {
    int articleNumber;
    String article;
    String description;
    String category;
    double price;

    public Product(int articleNumber, String article, String description, String category, double price) {
        this.articleNumber=articleNumber;
        this.article = article;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Product() {
        this.articleNumber = articleNumber;
        this.article = article;
        this.description = description;
        this.category = category;
        this.price = price;
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

    @Override
    public String toString() {
        return
                "\n" +
                article + "\n" + "Article number: " + articleNumber + "\n" + "Description: " + description + "\n" +
                "Price: " + price + " kr";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return articleNumber == product.articleNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleNumber);
    }
}
