package com.ecom.models;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class Cart{
    private Map<Product,Integer> cartList= new HashMap<>();

    double getNetPrice(){
        double netPrice =0;
        for (Map.Entry<Product, Integer> item : cartList.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();
            netPrice += product.getPrice() * quantity;
        }
        return netPrice;
    }
    public void addToCart(int productId, int quantity, Inventory inventory) {
        Optional<Product> currentProduct = inventory.findProductById(productId);
        if (currentProduct.isEmpty()) {
            System.out.println("PRODUCT DOES NOT EXIST");
            return;
        }
        Product product = currentProduct.get();
        if (quantity > product.getQuantity()) {
            System.out.println("Insufficient Quantity");
            return;
        }
        cartList.put(product, quantity);
    }
    public void removeFromCart(int productId, Inventory inventory){
        Optional<Product> currentProduct =inventory.findProductById(productId);
        if(currentProduct.isEmpty()){
            System.out.println("PRODUCT DOES NOT EXIST");
            return;
        }
        cartList.remove(currentProduct.get());
    }
    public void viewCart() {
        if(cartList.isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }
        for (Map.Entry<Product, Integer> e : cartList.entrySet()) {
            System.out.println(
                    "Product: " + e.getKey().getProductName() +
                            " | Price: " + e.getKey().getPrice() +
                            " | Quantity: " + e.getValue()
            );
        }
        System.out.println("Total Price: " + getNetPrice());
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