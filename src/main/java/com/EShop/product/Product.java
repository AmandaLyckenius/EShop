package com.EShop.product;

import java.util.Objects;

public class Product {
    private int articleNumber;
    private String article;
    private String description;
    private String category;
    private double price;

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

    public String getArticle() {
        return article;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "\n" +
                article + "\n" + "Article number: " + articleNumber + "\n" + "Description: " + description + "\n" +
                "Price: " + price + " kr" + "\n";
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
