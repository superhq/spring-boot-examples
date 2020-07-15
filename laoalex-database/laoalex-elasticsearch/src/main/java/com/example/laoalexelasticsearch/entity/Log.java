package com.example.laoalexelasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "init_service_nginx-*")
public class Log {
    @Id
    private String timestamp;
    private String level;
    private String class_;
    private String message;
}
