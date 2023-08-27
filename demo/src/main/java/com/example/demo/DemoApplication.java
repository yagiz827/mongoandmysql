package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.demo.Tournament","com.example.demo.User","com.example.demo.Matchmaking"})
@EnableMongoRepositories(basePackages = {"com.example.demo.mongo","com.example.demo.mongooo"})

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
