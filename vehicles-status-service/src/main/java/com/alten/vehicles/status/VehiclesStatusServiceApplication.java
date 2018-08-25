package com.alten.vehicles.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VehiclesStatusServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesStatusServiceApplication.class, args);
	}
}
