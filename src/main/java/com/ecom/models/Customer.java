package com.ecom.models;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Customer extends User{
    private List<Order> orderHistory= new ArrayList<>();
    private Cart cart =new Cart();
    public Customer(String name, String email, String password) {
        super(name, email, password);
    }

    public void displayInventory(Inventory inventory){
        inventory.viewInventory();
    }
    public void addToCart(int productId, int quantity, Inventory inventory){
        cart.addToCart(productId,quantity,inventory);
     }
     public void removeFromCart(int productId, Inventory inventory){
        cart.removeFromCart(productId, inventory);
     }
     public void viewCart(){
        cart.viewCart();
     }

    public void confirmOrder(Inventory inventory){

        if(cart.isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }
        for (Map.Entry<Product, Integer> e : cart.getItems().entrySet()) {
            Product currentProduct = e.getKey();
            Integer quantity = e.getValue();
            Optional<Product> inventoryProduct = inventory.findProductById(currentProduct.getProductId());
            if(inventoryProduct.isEmpty()){
                System.out.println("PRODUCT DOES NOT EXIST");
                return;
            }
            if(quantity > inventoryProduct.get().getQuantity()){
                System.out.println("Quantity exceeded, Product ID : " + currentProduct.getProductId());
                return;
            }
        }

        for (Map.Entry<Product, Integer> e : cart.getItems().entrySet()) {
            Product currentProduct = e.getKey();
            Integer quantity = e.getValue();
            Optional<Product> inventoryProduct = inventory.findProductById(currentProduct.getProductId());
            if(inventoryProduct.isEmpty()) return;
            inventoryProduct.get().setQuantity(
                    inventoryProduct.get().getQuantity() - quantity
            );
        }

        Order newOrder = new Order(this, cart);
        orderHistory.add(newOrder);
        System.out.println("Order placed successfully.");
        System.out.println("Total Price : " + newOrder.getNetCost());
        cart.clearCart();
    }

     public void viewOrderHistory(){
         for (Order order : orderHistory) {
             System.out.println(order);
             System.out.println("_________________________________");
         }
     }

}