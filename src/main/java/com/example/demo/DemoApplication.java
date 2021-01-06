package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
    	
        SpringApplication.run(DemoApplication.class, args);
    }

}
