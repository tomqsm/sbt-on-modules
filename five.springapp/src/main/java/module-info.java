import five.service.api.FiveService;

open module five.springapp {
    requires lombok;
    requires five.service;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.starter;
    requires spring.web;
    requires spring.beans;
    requires java.sql;
    uses FiveService;
}