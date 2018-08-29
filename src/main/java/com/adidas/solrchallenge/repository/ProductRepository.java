package com.adidas.solrchallenge.repository;

import com.adidas.solrchallenge.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Collection;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

    Page<Product> findByNameOrDescription(@Boost(2) String name, String description, Pageable page);

    @Highlight
    HighlightPage<Product> findByNameIn(Collection<String> name, Pageable page);
}
