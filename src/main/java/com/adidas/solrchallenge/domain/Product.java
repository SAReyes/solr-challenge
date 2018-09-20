package com.adidas.solrchallenge.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Data
@SolrDocument(solrCoreName = "product")
public class Product {

    @Id
    @Indexed(name = "id")
    private String id;
    @Indexed(name = "description")
    private String description;
    @Indexed(name = "name")
    private String name;
    @Indexed(name = "model_number")
    private String modelNumber;
    @Indexed(name = "price")
    private double price;
    @Indexed(name = "colors")
    private List<String> colors;
    @Indexed(name = "category")
    private String category;
    @Indexed(name = "search_color")
    private String searchColor;
}
