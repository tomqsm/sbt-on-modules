open module five.authentication.microservice {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.starter;
    requires spring.web;
    requires spring.beans;
    requires java.sql;
    requires slf4j.api;
    requires spring.core;
    requires spring.cloud.context;
    requires guava;
    requires spring.cloud.commons;
    requires spring.cloud.zookeeper.core;
//    requires spring.cloud.zookeeper.discovery;
//    requires spring.cloud.starter.feign;
    requires spring.cloud.openfeign.core;
    requires spring.cloud.netflix.ribbon;
//    requires ribbon;
}