package com.ecom.searches;

import com.ecom.models.Product;
import java.util.List;

public class NameSearchStrategy implements SearchStrategy {
    private final String queryName;

    public NameSearchStrategy(String queryName) {
        this.queryName = queryName;
    }

    @Override
    public List<Product> search(List<Product> products) {
        return products.stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(queryName))
                .toList();
    }
}