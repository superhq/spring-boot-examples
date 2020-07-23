#  1. 关于 Elasticsearch
Elasticsearch 是一个分布式的 RESTful 搜索和分析引擎，可用来集中存储您的数据，以便您对形形色色、规模不一的数据进行搜索、索引和分析。
我们可以在[这里](https://www.elastic.co/cn/downloads/elasticsearch)下载Elasticsearch的安装文件，建议下载二进制压缩文件。对于本文的读者，您只需解压下载的文件，然后执行下面的命令即可启动Elasticsearch。

```shell
cd ./elasticsearch-7.8.0/bin
./elasticsearch
```



 # 2. Spring Data

Spring Data 是 Spring 的一个子项目。用于简化数据访问，支持NoSQL 和 关系数据库，map-reduce框架和基于云的数据服务。其主要目标是使数据的访问变得方便快捷。从[官网](https://spring.io/projects/spring-data#overview)中可以看到目前Spring Data支持的数据种类非常多。Elasticsearch是其中的一种。

## 2.1 Maven依赖

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
```

## 2.2 配置文件

编辑application.properties文件，增加如下内容：

```properties
spring.data.elasticsearch.client.reactive.endpoints=127.0.0.1:9200
spring.data.elasticsearch.repositories.enabled=true
```

## 2.3 定义实体类

```java
//注意indexName要小写
@Document(indexName = "blog")
@Setter
@Getter
@ToString
public class Article {
    @Id
    private String id;
    private String title;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;

    public Article(String title) {
        this.title = title;
    }
}

public class Author {
    private String name;
    public Author(String name) {
        this.name = name;
    }
}
```

## 2.4 定义Repository接口

```java
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article,String> {

    //下面的这两个查询的作用是一样的。一个采用默认的实现方式，一个采用自定义的实现方式
    Page<Article> findByAuthorsName(String name, Pageable pageable);
    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

    //搜索title字段
    Page<Article> findByTitleIsContaining(String word,Pageable pageable);
    
    Page<Article> findByTitle(String title,Pageable pageable);
}
```

# 3 使用

## 3.1 在测试类中自动装载repository和template实例

```java
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
```

## 3.2 检查index是否存在

```java

    //检查相应的索引是否存在，如果spring.data.elasticsearch.repositories.enabled=True,则会自动创建索引
    private boolean checkIndexExists(Class<?> cls){
        boolean isExist = elasticsearchRestTemplate.indexOps(cls).exists();
        //获取索引名
        String indexName = cls.getAnnotation(Document.class).indexName();
        System.out.printf("index %s is %s\n", indexName, isExist ? "exist" : "not exist");
        return isExist;
    }
    @Test
    void checkIndex() {
        checkIndexExists(Article.class);
    }
```

## 3.2 新增数据

```java
    @Test
     void save(){
        Article article = new Article("Spring Data Elasticsearch");
        article.setAuthors(asList(new Author("LaoAlex"),new Author("John")));
        articleRepository.save(article);

        article = new Article("Spring Data Elasticsearch2");
        article.setAuthors(asList(new Author("LaoAlex"),new Author("King")));
        articleRepository.save(article);

        article = new Article("Spring Data Elasticsearch3");
        article.setAuthors(asList(new Author("LaoAlex"),new Author("Bill")));
        articleRepository.save(article);
    }
```

## 3.3 查询

```java
    @Test
    void queryAuthorName() throws JsonProcessingException {
        Page<Article> articles = articleRepository.findByAuthorsName("LaoAlex", PageRequest.of(0,10));
        //将对象转为Json字符串
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(articles);
        System.out.println(json);
    }

    //使用自定义查询
    @Test
    void queryAuthorNameByCustom() throws JsonProcessingException {
        Page<Article> articles = articleRepository.findByAuthorsNameUsingCustomQuery("John",PageRequest.of(0,10));
        //将对象转为Json字符串
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(articles);
        System.out.println(json);
    }

```



## 3.4 使用template进行查询

```java
    //使用Template进行关键字查询
    //关于正则表达式可以参考https://www.runoob.com/java/java-regular-expressions.html
    //.*data.* 可以匹配ddata, dataa等
    @Test
    void queryTileContainByTemplate() throws JsonProcessingException {
        Query query = new NativeSearchQueryBuilder().withFilter(regexpQuery("title",".*elasticsearch2.*")).build();
        SearchHits<Article> articles = elasticsearchRestTemplate.search(query, Article.class, IndexCoordinates.of("blog"));
        //将对象转为Json字符串
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(articles);
        System.out.println(json);
    }
```

## 3.5 更新

```java
    @Test
    void update() throws JsonProcessingException {
        Page<Article> articles = articleRepository.findByTitle("Spring Data Elasticsearch",PageRequest.of(0,10));
        //将对象转为Json字符串
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(articles);
        System.out.println(json);

        Article article = articles.getContent().get(0);
        System.out.println(article);
        article.setAuthors(null);
        articleRepository.save(article);
    }
```

## 3.6 删除

```java
    @Test
    void delete(){
        Page<Article> articles = articleRepository.findByTitle("Spring Data Elasticsearch",PageRequest.of(0,10));
        Article article = articles.getContent().get(0);
        articleRepository.delete(article);
    }
```

# 4 总结

本文使用Spring Data对Elasticsearch进行了增、删、改、查操作。原代码以及放在GitHub上(https://github.com/superhq/LaoAlexJava.git)。