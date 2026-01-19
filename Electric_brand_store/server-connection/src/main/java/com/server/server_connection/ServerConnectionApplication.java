package com.server.server_connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerConnectionApplication.class, args);
	}

}
