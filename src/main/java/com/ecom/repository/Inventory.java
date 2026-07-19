package com.ecom.repository;
import com.ecom.models.Product;
import com.ecom.models.Seller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Inventory{
    private static volatile Inventory instance = null;
    private final List<Product> inventory = new ArrayList<>();

    // Private constructor blocks direct instantiation
    private Inventory() {}

    // Double-Checked Locking Singleton Pattern implementation
    public static Inventory getInstance() {
        if (instance == null) {
            synchronized (Inventory.class) {
                if (instance == null) {
                    instance = new Inventory();
                }
            }
        }
        return instance;
    }
    public boolean addProduct(Product product){
        inventory.add(product);
        return true;
    }
    public boolean deleteProduct(int productId){
        inventory.removeIf(product ->
                product.getProductId() == productId);
        return true;
    }
    public boolean updateProduct(int productId, String category, double price, int quantity, Seller seller, String productName){
        for (Product product : inventory) {
            if (product.getProductId() == productId) {
                product.setProductName(productName);
                product.setCategory(category);
                product.setPrice(price);
                product.setQuantity(quantity);
                return true;
            }
        }
        throw new IllegalArgumentException("Product not found");
    }
    public Optional<Product> findProductById(int productId){

        return inventory.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }
    public List<Product> getAllProducts() {
        return new ArrayList<>(inventory);
    }
    public List<Product> search(com.ecom.searches.SearchStrategy strategy) {
        return strategy.search(new ArrayList<>(this.inventory));
    }
}