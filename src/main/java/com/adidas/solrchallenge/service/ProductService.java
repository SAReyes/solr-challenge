package com.adidas.solrchallenge.service;

import com.adidas.solrchallenge.domain.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> create(Product product);
}
