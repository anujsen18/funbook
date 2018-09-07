package com.funbook.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@ComponentScan("com.funbook")
@EnableJpaRepositories("com.funbook.dao") 
@EntityScan("com.funbook.beans")
@SpringBootApplication
public class Application extends SpringBootServletInitializer  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}