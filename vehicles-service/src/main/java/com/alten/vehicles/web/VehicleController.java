package com.alten.vehicles.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alten.vehicles.entity.Customer;
import com.alten.vehicles.service.VehicleService;
import com.alten.vehicles.status.bean.VehicleStatusBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class VehicleController {

	@Autowired
	VehicleService vs;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return vs.getAllCustomers();
	}
	
	@GetMapping("/getVehicleStatus/{vehicleId}")
	public VehicleStatusBean getVehicleStatus(@PathVariable String vehicleId) {
		return vs.getVehicleStatus(vehicleId);
	}
	
	
}
