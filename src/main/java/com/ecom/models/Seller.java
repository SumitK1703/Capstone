package com.ecom.models;
public class Seller extends User{
    public Seller(String name, String email, String password) {
        super(name, email, password);
    }
    public void addProduct(Product product, Inventory inventory) {
        inventory.addProduct(product);
    }

    public void deleteProduct(Product product, Inventory inventory) {
        inventory.deleteProduct(product.getProductId());
    }

    public void updateProduct(int productId, String category, double price, int quantity, Seller seller, String productName, Inventory inventory) {
        inventory.updateProduct(productId, category, price, quantity, seller, productName);
    }
}