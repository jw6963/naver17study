package com.demo.mvc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"*.test","data.dto"})
public class Mvc2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mvc2Application.class, args);
    }

}
