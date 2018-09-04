package com.alten.vehicles.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alten.vehicles.entity.Customer;
import com.alten.vehicles.service.VehicleService;
import com.alten.vehicles.status.bean.VehicleStatusBean;

@RestController
public class VehicleController {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	VehicleService vs;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		logger.info("Calling  getAllCustomers in VehicleController");
		return vs.getAllCustomers();
	}
	
	@GetMapping("/getVehicleStatus/{vehicleId}")
	public VehicleStatusBean getVehicleStatus(@PathVariable String vehicleId) {
		return vs.getVehicleStatus(vehicleId);
	}
	
	
}
