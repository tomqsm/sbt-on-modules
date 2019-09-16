import five.service.api.FiveService;
import five.service.spring.api.FiveServiceSpring;

open module five.springapp {
    requires five.service;
    requires five.service.spring;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.starter;
    requires spring.web;
    requires spring.beans;
    requires java.sql;
    requires slf4j.api;
    requires spring.core;
    requires org.apache.commons.lang3;
    requires spring.cloud.context;
    requires guava;
    requires spring.cloud.commons;
    requires spring.cloud.zookeeper.core;
//    requires spring.cloud.zookeeper.discovery;
    uses FiveService;
    uses FiveServiceSpring;
}