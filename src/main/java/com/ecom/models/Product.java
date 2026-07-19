package com.ecom.models;

public class Product {
    private static int currentProductId = 100;
    private final int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private Seller seller;
    public Product(String category, double price, int quantity, Seller seller, String productName) {
        if (price < 0) {
            throw new IllegalArgumentException("Product construction failed: Price cannot be negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Product construction failed: Quantity cannot be negative.");
        }
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product construction failed: Product name cannot be null or empty.");
        }

        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
        this.productName = productName;
        this.productId = currentProductId++;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product Name cannot be null or empty.");
        }
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if (price < 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean setQuantity(int quantity) {
        if (quantity < 0) {
            return false;
        }
        this.quantity = quantity;
        return true;
    }

    public String getCategory() {
        return category;
    }

    public boolean setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            return false;
        }
        this.category = category;
        return true;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                "\nName: " + productName +
                "\nCategory: " + category +
                "\nPrice: " + price +
                "\nQuantity: " + quantity;
    }
}