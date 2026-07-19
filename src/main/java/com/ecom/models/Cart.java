package com.ecom.models;
import com.ecom.repository.Inventory;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class Cart{
    private Map<Product,Integer> cartList= new HashMap<>();

    public double getNetPrice(){
        double netPrice =0;
        for (Map.Entry<Product, Integer> item : cartList.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();
            netPrice += product.getPrice() * quantity;
        }
        return netPrice;
    }
    public boolean addToCart(int productId, int quantity, Inventory inventory) {
        Optional<Product> currentProduct = inventory.findProductById(productId);
        if (currentProduct.isEmpty()) {
            return false;
        }
        Product product = currentProduct.get();
        if (quantity > product.getQuantity()) {
            return false;
        }
        cartList.put(product, quantity);
        return true;
    }
    public boolean removeFromCart(int productId, Inventory inventory){
        Optional<Product> currentProduct =inventory.findProductById(productId);
        if(currentProduct.isEmpty()){
            return false;
        }
        cartList.remove(currentProduct.get());
        return true;
    }
    public boolean viewCart() {
        if(cartList.isEmpty()){
            return false;
        }
        for (Map.Entry<Product, Integer> e : cartList.entrySet()) {
            System.out.println(
                    "Product: " + e.getKey().getProductName() +
                            " | Price: " + e.getKey().getPrice() +
                            " | Quantity: " + e.getValue()
            );
        }
        System.out.println("Total Price: " + getNetPrice());
        return true;
    }
    public boolean isEmpty(){
        return cartList.isEmpty();
    }
    public Map<Product, Integer> getItems() {
        return cartList;
    }
    public void clearCart() {
        cartList.clear();
    }
}