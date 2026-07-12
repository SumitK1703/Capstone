package com.ecom.models;
public class Product{
    private static int currentProductId=100;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private Seller seller;
    private final int productId;
    public Product(String category, double price, int quantity, Seller seller, String productName){
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.category=category;
        this.price=price;
        this.quantity=quantity;
        this.seller=seller;
        productId=currentProductId;
        currentProductId++;
        this.productName=productName;
    }
    public int getProductId() {
        return productId;
    }
    public String getProductName() {return productName;}

    public void setProductName(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Product Name cannot be null.");
        }
        this.productName = productName;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }


    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }
        this.category = category;
    }
    public void setSeller(Seller seller){
        this.seller=seller;
    }
    public Seller getSeller() {
        return seller;
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