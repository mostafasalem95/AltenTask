package com.alten.vehicles.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
public class VehiclesGatewayApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(VehiclesGatewayApplication.class);

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@GetMapping("/test")
	public String getAllCustomers() {
		logger.info("Calling  getAllCustomers in VehicleController");
		return "Hello";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VehiclesGatewayApplication.class, args);
	}
}
