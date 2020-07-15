package com.example.laoalexelasticsearch.controller;

import com.example.laoalexelasticsearch.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsController {
    @Autowired
    private ElasticsearchTemplate template;
    @GetMapping("/test")
    public Log test(){
        GetQuery query = new GetQuery("T7OVUHMBq4ESkCSgFbqq");
        return template.queryForObject(query, Log.class);
    }
}
