package com.adidas.solrchallenge.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(solrCoreName = "product")
public class Product {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;
    @Indexed(name = "description", type = "string")
    private String description;
    @Indexed(name = "name", type = "string")
    private String name;
}
