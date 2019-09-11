import five.service.spring.FiveServiceSpringImpl;
import five.service.spring.api.FiveServiceSpring;

open module five.service.spring {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.starter;
    requires spring.web;
    requires spring.beans;
    requires org.mybatis;
    requires org.mybatis.spring;
    requires java.sql;
    requires spring.jdbc;
    requires spring.core;
    requires org.apache.commons.lang3;
    requires slf4j.api;
    exports five.service.spring.api;
    provides FiveServiceSpring with FiveServiceSpringImpl;
}