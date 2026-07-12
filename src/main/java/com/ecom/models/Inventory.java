package com.ecom.models;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Inventory{
    private List <Product> inventory= new ArrayList<>();
    public void addProduct(Product p){
        inventory.add(p);
    }
    public void deleteProduct(int productId){
        inventory.removeIf(product ->
                product.getProductId() == productId);
    }
    public void updateProduct(int productId, String category, double price, int quantity, Seller seller, String productName){
        for (Product product : inventory) {
            if (product.getProductId() == productId) {
                product.setProductName(productName);
                product.setCategory(category);
                product.setPrice(price);
                product.setQuantity(quantity);
                return;
            }
        }
        System.out.println("PRODUCT ID DOES NOT EXIST");
    }
    public Optional<Product> findProductById(int productId){

        return inventory.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }
    public void viewInventory(){
        inventory.forEach(System.out::println);
    }
    public void searchProductByName(String productName){
        List<Product> result = inventory.stream()
                .filter(product -> product.getProductName().equalsIgnoreCase(productName))
                .toList();
        if(result.isEmpty()){
            System.out.println("PRODUCT NAME DOES NOT EXIST");
        }
        else{
            result.forEach(System.out::println);
        }
    }
    public void searchProductByCategory(String category) {

        List<Product> result = inventory.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();

        if (result.isEmpty()) {
            System.out.println("PRODUCT CATEGORY DOES NOT EXIST");
        }
        else {
            result.forEach(System.out::println);
        }
    }
    public void searchProductByPrice(double priceMin, double priceMax) {
        List<Product> result = inventory.stream()
                .filter(product -> product.getPrice() >= priceMin
                        && product.getPrice() <= priceMax)
                .toList();

        if (result.isEmpty()) {
            System.out.println("NO PRODUCTS FOUND IN THIS PRICE RANGE");
        }
        else {
            result.forEach(System.out::println);
        }
    }
}