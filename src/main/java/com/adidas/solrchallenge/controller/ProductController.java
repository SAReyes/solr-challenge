package com.adidas.solrchallenge.controller;

import com.adidas.solrchallenge.domain.Product;
import com.adidas.solrchallenge.dto.CreateProductRequest;
import com.adidas.solrchallenge.dto.CreateProductResponse;
import com.adidas.solrchallenge.error.ProductRuntimeException;
import com.adidas.solrchallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public Object search() {
        throw new NotImplementedException();
    }

    @PostMapping("/{id}")
    public CreateProductResponse post(@PathVariable String id, @RequestBody CreateProductRequest request) {
        Product product = new Product();
        product.setId(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());

        Optional<Product> result = productService.create(product);

        if (result.isPresent()) {
            CreateProductResponse response = new CreateProductResponse();
            response.setId(result.get().getId());
            response.setName(result.get().getName());
            response.setDescription(result.get().getDescription());

            return response;
        } else {
            throw new ProductRuntimeException("Could not create the product" + id);
        }
    }
}
