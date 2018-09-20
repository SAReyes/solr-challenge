package com.adidas.solrchallenge.service;

import com.adidas.solrchallenge.domain.Product;
import com.adidas.solrchallenge.repository.ProductRepository;

import java.util.Optional;

public class DefaultProductService implements ProductService {

    private ProductRepository repository;

    public DefaultProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> save(Product product) {
        Product response = repository.save(product);

        return Optional.ofNullable(response);
    }
}
