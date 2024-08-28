package com.example.latihan1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Latihan1Application {

	public static void main(String[] args) {
		SpringApplication.run(Latihan1Application.class, args);
	}

}
