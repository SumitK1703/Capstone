package com.ecom.models;
import java.time.*;
import java.util.Map;
import java.util.HashMap;
public class Order{
    private final LocalDate orderDate = LocalDate.now();
    private final Customer buyer;
    private static int currOrderId = 100;
    private final int orderId;
    private double netCost;
    private Map<Product,Integer> order = new HashMap<>();
    public Order(Customer buyer, Cart cart) {
        this.buyer = buyer;
        orderId = currOrderId++;
        order.putAll(cart.getItems());
        netCost = cart.getNetPrice();
    }

    public double getNetCost() {
        return netCost;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                "\nDate: " + orderDate +
                "\nTotal Cost: " + netCost;
    }
}