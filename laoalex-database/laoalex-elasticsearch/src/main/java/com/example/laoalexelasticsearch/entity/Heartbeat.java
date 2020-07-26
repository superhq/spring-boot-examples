package com.example.laoalexelasticsearch.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "heartbeat")
@Getter
@Setter
@ToString
public class Heartbeat {
    @Id
    String id;
    String sn;
    Date date;
    public Heartbeat(String sn){
        this.sn = sn;
        this.date = new Date();
    }
}
