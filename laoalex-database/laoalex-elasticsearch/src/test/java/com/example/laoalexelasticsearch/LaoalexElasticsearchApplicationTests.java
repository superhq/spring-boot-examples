package com.example.laoalexelasticsearch;

import com.example.laoalexelasticsearch.entity.Article;
import com.example.laoalexelasticsearch.entity.Author;
import com.example.laoalexelasticsearch.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import static java.util.Arrays.asList;

@SpringBootTest
class LaoalexElasticsearchApplicationTests {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void contextLoads() {
    }



    //检查相应的索引是否存在，如果spring.data.elasticsearch.repositories.enabled=True,则会自动创建索引
    private void checkIndexExists(Class<?> cls){
        boolean isExist = elasticsearchRestTemplate.indexOps(cls).exists();
        //获取索引名
        String indexName = cls.getAnnotation(Document.class).indexName();
        System.out.printf("index %s is %s\n", indexName, isExist ? "exist" : "not exist");
    }
    @Test
    void checkIndex() {
        checkIndexExists(Article.class);
        checkIndexExists(Author.class);

    }
    @Test
     void save(){
        Article article = new Article("Spring Data Elasticsearch2");
        article.setAuthors(asList(new Author("LaoAlex"),new Author("John")));
        articleRepository.save(article);
    }

}