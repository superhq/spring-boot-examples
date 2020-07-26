package com.example.laoalexelasticsearch.repository;

import com.example.laoalexelasticsearch.entity.Heartbeat;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartbeatRepository extends ElasticsearchRepository<Heartbeat,String> {
}
