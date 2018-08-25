package com.alten.vehicles.status.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.alten.vehicles.status.bean.VehicleStatusBean;
import com.alten.vehicles.status.service.VehicleStatusService;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {
	
	
	private String[] status = {"Stopped", "Running"};
	private List<String> vehiclesId = new ArrayList<>();
	
	public VehicleStatusServiceImpl() {
		vehiclesId.add("YS2R4X20005399401");
		vehiclesId.add("VLUR4X20009093588");
		vehiclesId.add("VLUR4X20009048066");
		vehiclesId.add("YS2R4X20005388011");
		vehiclesId.add("YS2R4X20005387949");
		vehiclesId.add("VLUR4X20009047066");
		vehiclesId.add("YS2R4X20005387055");
		
	}

	@Override
	public VehicleStatusBean getVehicleStatus(String vehicleId) {
		
		VehicleStatusBean vsb = new VehicleStatusBean();
		vsb.setVehicleId(vehicleId);
		
		if(!vehicleId.trim().equals("")) {	
			if(vehiclesId.contains(vehicleId)) {
				Random rand = new Random();
				vsb.setStatus(status[rand.nextInt(2)]);
			} else {
				vsb.setStatus("Vehicle not exist");
			}
		}
		
		return vsb;
	}
	
	

}
