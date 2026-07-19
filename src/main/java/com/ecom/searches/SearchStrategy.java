package com.ecom.searches;

import com.ecom.models.Product;

import java.util.List;

public interface SearchStrategy {
    List<Product> search(List<Product> products);
}
