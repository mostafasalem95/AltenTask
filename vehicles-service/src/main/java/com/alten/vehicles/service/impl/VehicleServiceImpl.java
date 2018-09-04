package com.alten.vehicles.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alten.vehicles.entity.Customer;
import com.alten.vehicles.proxy.VehicleStatusServiceProxy;
import com.alten.vehicles.repository.ICustomerRepo;
import com.alten.vehicles.service.VehicleService;
import com.alten.vehicles.status.bean.VehicleStatusBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VehicleServiceImpl implements VehicleService {

	private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private VehicleStatusServiceProxy vssp;
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> c = new ArrayList<Customer>();
		try{
			c = customerRepo.findAll();
			logger.info("Getting All the Customers");
		}catch(Exception ex) {
			// do some logging and exception handling
			System.out.println(ex.getMessage());
		}
		return c;
	}

	@HystrixCommand(groupKey="fallback", commandKey="fallback", fallbackMethod="statusFallback")
	@Override
	public VehicleStatusBean getVehicleStatus(String vehicleId) {
		VehicleStatusBean b = vssp.getVehicleStatus(vehicleId);
		return b;
	}

	
	public VehicleStatusBean statusFallback(String vehicleId) {
		VehicleStatusBean vs = new VehicleStatusBean();
		vs.setVehicleId(vehicleId);
		vs.setStatus("Status not found");
		return vs;
	}

	
	
}
