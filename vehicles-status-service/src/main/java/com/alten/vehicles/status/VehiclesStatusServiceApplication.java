package com.alten.vehicles.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class VehiclesStatusServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesStatusServiceApplication.class, args);
	}
}
