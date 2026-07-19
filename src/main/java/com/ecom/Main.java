package com.ecom;

import com.ecom.models.*;
import com.ecom.repository.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventory inventory = new Inventory();
        List<User> users = new ArrayList<>();

        // ================= CREATE USERS =================

        Admin admin = (Admin) UserFactory.createUser(
                "admin",
                "Admin",
                "admin@ecom.com",
                "admin123"
        );

        Seller seller = (Seller) UserFactory.createUser(
                "seller",
                "Rahul",
                "rahul@ecom.com",
                "seller123"
        );

        Customer customer = (Customer) UserFactory.createUser(
                "customer",
                "Sumit",
                "sumit@ecom.com",
                "customer123"
        );

        users.add(admin);
        users.add(seller);
        users.add(customer);

        admin.register();
        seller.register();
        customer.register();

        // ================= LOGIN =================

        System.out.println("\n========== CUSTOMER LOGIN ==========");

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        customer.login(email, password);

        // ================= CREATE PRODUCTS =================

        Product p1 = new Product(
                "Electronics",
                55000,
                10,
                seller,
                "Laptop"
        );

        Product p2 = new Product(
                "Electronics",
                25000,
                8,
                seller,
                "Tablet"
        );

        Product p3 = new Product(
                "Books",
                850,
                20,
                seller,
                "Java Programming"
        );

        Product p4 = new Product(
                "Accessories",
                1500,
                15,
                seller,
                "Headphones"
        );

        Product p5 = new Product(
                "Electronics",
                85000,
                5,
                seller,
                "Gaming PC"
        );

        // ================= PRODUCT MANAGEMENT =================

        seller.addProduct(p1, inventory);
        seller.addProduct(p2, inventory);
        seller.addProduct(p3, inventory);
        seller.addProduct(p4, inventory);
        seller.addProduct(p5, inventory);

        System.out.println("\n========== INVENTORY ==========\n");
        customer.displayInventory(inventory);

        // ================= SEARCH =================

        System.out.println("\n========== SEARCH PRODUCT BY NAME ==========");

        System.out.print("Enter Product Name : ");
        String name = sc.nextLine();

        inventory.searchProductByName(name);

        System.out.println("\n========== SEARCH PRODUCT BY CATEGORY ==========");

        System.out.println("Available Categories:");
        System.out.println("1. Electronics");
        System.out.println("2. Books");
        System.out.println("3. Accessories");

        System.out.print("\nEnter Category Name exactly as shown: ");
        String category = sc.nextLine();

        inventory.searchProductByCategory(category);

        System.out.println("\n========== SEARCH PRODUCT BY PRICE RANGE ==========");

        System.out.print("Minimum Price : ");
        double min = sc.nextDouble();

        System.out.print("Maximum Price : ");
        double max = sc.nextDouble();

        inventory.searchProductByPrice(min, max);

        // ================= CART =================

        System.out.println("\n========== ADD TO CART ==========");

        customer.addToCart(
                p1.getProductId(),
                1,
                inventory
        );

        customer.addToCart(
                p3.getProductId(),
                2,
                inventory
        );

        customer.addToCart(
                p4.getProductId(),
                1,
                inventory
        );

        System.out.println("\n========== CART ==========");
        customer.viewCart();

        // ================= REMOVE =================

        System.out.println("\nRemoving Headphones from Cart...\n");

        customer.removeFromCart(
                p4.getProductId(),
                inventory
        );

        System.out.println("========== UPDATED CART ==========");
        customer.viewCart();

        // ================= ORDER =================

        System.out.println("\n========== PLACE ORDER ==========");

        customer.confirmOrder(inventory);

        // ================= HISTORY =================

        System.out.println("\n========== ORDER HISTORY ==========");

        customer.viewOrderHistory();

        // ================= UPDATED INVENTORY =================

        System.out.println("\n========== UPDATED INVENTORY ==========");

        customer.displayInventory(inventory);

        // ================= UPDATE PROFILE =================

        System.out.println("\n========== UPDATE PROFILE ==========");

        customer.updateProfile(
                "Sumit Kanojiya",
                "sumitk@ecom.com",
                "newPassword123"
        );

        // ================= DELETE USER =================

        System.out.println("\n========== DELETE USER ==========");

        admin.deleteUser(
                seller.getUserId(),
                users
        );

        // ================= LOGOUT =================

        System.out.println("\n========== LOGOUT ==========");

        customer.logout();

        System.out.println("\n========== UPDATE PRODUCT ==========");

        seller.updateProduct(
                p2.getProductId(),
                "Electronics",
                22000,
                10,
                seller,
                "Tablet",
                inventory
        );

        System.out.println("\n========== DELETE PRODUCT ==========");

        seller.deleteProduct(p5, inventory);

        System.out.println("\n========== INVENTORY AFTER UPDATE & DELETE ==========\n");

        customer.displayInventory(inventory);

        sc.close();
    }
}