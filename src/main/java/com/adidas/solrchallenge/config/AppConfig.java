package com.adidas.solrchallenge.config;

import com.adidas.solrchallenge.repository.ProductRepository;
import com.adidas.solrchallenge.service.DefaultProductService;
import com.adidas.solrchallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final ProductRepository productRepository;

    @Autowired
    public AppConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductService productService() {
        return new DefaultProductService(productRepository);
    }
}
