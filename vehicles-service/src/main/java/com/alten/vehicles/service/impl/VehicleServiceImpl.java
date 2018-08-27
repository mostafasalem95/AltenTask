package com.alten.vehicles.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
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

	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private VehicleStatusServiceProxy vssp;
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> c = new ArrayList<Customer>();
		try{
			c = customerRepo.findAll();
		}catch(Exception ex) {
			// do some logging and exception handling
			System.out.println(ex.getMessage());
		}
		return c;
	}

	@HystrixCommand(groupKey="fallback", commandKey="fallback", fallbackMethod="statusFallback")
	@Override
	public VehicleStatusBean getVehicleStatus(String vehicleId) {
		VehicleStatusBean b = new VehicleStatusBean();
		try{
			b = vssp.getVehicleStatus(vehicleId);
		}catch(Exception ex) {
			// do some logging and exception handling
			System.out.println(ex.getMessage());
		}
		return b;
	}

	
	public VehicleStatusBean statusFallback(String vehicleId) {
		VehicleStatusBean vs = new VehicleStatusBean();
		vs.setVehicleId(vehicleId);
		vs.setStatus("Status not found");
		return vs;
	}

	
	
}
