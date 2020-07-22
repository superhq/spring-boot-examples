package com.example.laoalexelasticsearch.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.example.laoalexelasticsearch.repository")
//public class EsConfig {
//    @Bean
//    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("127.0.0.1:9200")
//                .build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//    @Bean(name = "elasticsearchRestTemplate")
//    public ElasticsearchOperations elasticsearchRestTemplate(){
//        return new ElasticsearchRestTemplate(client());
//    }
//}
