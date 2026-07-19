package com.ecom.models;

import com.ecom.repository.Inventory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Customer extends User {
    private final List<Order> orderHistory = new ArrayList<>();
    private final Cart cart = new Cart();

    public Customer(String name, String email, String password) {
        super(name, email, password);
    }

    public boolean addToCart(int productId, int quantity, Inventory inventory) {
        return cart.addToCart(productId, quantity, inventory);
    }

    public boolean removeFromCart(int productId, Inventory inventory) {
        return cart.removeFromCart(productId, inventory);
    }

    public Cart getCart() {
        return cart;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public boolean confirmOrder(Inventory inventory) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Checkout failed: Your shopping cart is empty.");
        }

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product currentProduct = entry.getKey();
            Integer requestedQuantity = entry.getValue();

            Optional<Product> inventoryProduct = inventory.findProductById(currentProduct.getProductId());

            if (inventoryProduct.isEmpty()) {
                throw new IllegalArgumentException("Checkout failed: Product '" + currentProduct.getProductName() + "' no longer exists in inventory.");
            }

            if (requestedQuantity > inventoryProduct.get().getQuantity()) {
                throw new IllegalArgumentException("Checkout failed: Insufficient stock for '" + currentProduct.getProductName() +
                        "'. Requested: " + requestedQuantity + ", Available: " + inventoryProduct.get().getQuantity());
            }
        }

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product currentProduct = entry.getKey();
            Integer requestedQuantity = entry.getValue();

            Optional<Product> inventoryProduct = inventory.findProductById(currentProduct.getProductId());
            inventoryProduct.ifPresent(product -> product.setQuantity(product.getQuantity() - requestedQuantity));
        }
        Order newOrder = new Order(this, cart);
        orderHistory.add(newOrder);
        cart.clearCart();

        return true;
    }
}