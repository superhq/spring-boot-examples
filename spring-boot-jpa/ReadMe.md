# Jpa
java persistence api。java 持久化api。

ORM,对象关系映射。用于将对象持久化到数据库，并进于访问和管理。

Hibernate是一个ORM框架，最初是由Gavin King 在2002年实现。

JPA不是工具或是框架，它只是定义一个概念。这些概念可能被用于任何工具或框架。

最早的JPA实现是采用ORM方式的，如Hibernate。但是随着技术的发展，JPA的实现也可以将对象存在非关系型数据库（NoSQL），如EclipseLink，Hibernate OGM。


![JAP 层](https://images.idgesg.net/images/article/2019/04/jw_java_persistence_series_1200x1600_diagram-100792564-large.jpg)


# JPA的使用
jpa需要有一个具体的实现，称为jpa provider，如Hibernate 或 EclipseLink

这些具体的实现需要配置数据库的链接，如jdbc

# 参考
- [1]：https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html