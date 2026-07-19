package com.ecom.searches;

import com.ecom.models.Product;
import java.util.List;

public class PriceSearchStrategy implements SearchStrategy {
    private final double minPrice;
    private final double maxPrice;

    public PriceSearchStrategy(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> search(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .toList();
    }
}