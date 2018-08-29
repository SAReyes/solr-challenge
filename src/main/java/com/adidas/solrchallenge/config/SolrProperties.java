package com.adidas.solrchallenge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "challenge.solr")
@Data
public class SolrProperties {
    private String host;
    private String protocol;
    private String port;
}
