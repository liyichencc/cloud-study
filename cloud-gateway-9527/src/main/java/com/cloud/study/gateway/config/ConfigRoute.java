//package com.cloud.study.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ConfigRoute {
//    @Bean
//    public RouteLocator cusotomRouteLocator(RouteLocatorBuilder builder) {
//
//        RouteLocatorBuilder.Builder routes = builder.routes();
//
//        routes.route("news01",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
//
//        routes.route("news02",r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
//        return routes.build();
//
//    }
//}
