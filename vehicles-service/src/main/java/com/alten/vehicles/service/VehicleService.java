package com.alten.vehicles.service;

import java.util.List;

import com.alten.vehicles.entity.Customer;
import com.alten.vehicles.status.bean.VehicleStatusBean;

public interface VehicleService {
	
	public List<Customer> getAllCustomers();
	public VehicleStatusBean getVehicleStatus(String vehicleId);

}
