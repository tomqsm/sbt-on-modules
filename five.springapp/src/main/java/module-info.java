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
    uses FiveService;
    uses FiveServiceSpring;
}