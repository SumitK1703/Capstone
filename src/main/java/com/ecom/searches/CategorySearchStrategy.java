package com.ecom.searches;

import com.ecom.models.Product;
import java.util.List;

public class CategorySearchStrategy implements SearchStrategy {
    private final String queryCategory;

    public CategorySearchStrategy(String queryCategory) {
        this.queryCategory = queryCategory;
    }

    @Override
    public List<Product> search(List<Product> products) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(queryCategory))
                .toList();
    }
}