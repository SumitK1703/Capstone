package com.ecom.models;

import com.ecom.repository.Inventory;

public class Seller extends User {

    public Seller(String name, String email, String password) {
        super(name, email, password);
    }

    public boolean addProduct(Product product, Inventory inventory) {
        return inventory.addProduct(product);
    }

    public boolean deleteProduct(Product product, Inventory inventory) {
        if (product == null) {
            return false;
        }
        return inventory.deleteProduct(product.getProductId());
    }

    public boolean updateProduct(int productId, String category, double price, int quantity,
                                 Seller seller, String productName, Inventory inventory) {
        return inventory.updateProduct(productId, category, price, quantity, seller, productName);
    }
}