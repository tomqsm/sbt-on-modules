import five.service.api.FiveService;

open module five.springapp {
    requires lombok;
    requires org.apache.logging.slf4j;
    requires five.service;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.boot.starter.web;
    requires spring.context;
    requires spring.boot.starter;
    requires spring.web;
    requires spring.beans;
    requires spring.core;
    requires java.sql;
    uses FiveService;
}