package com.alten.vehicles.status.bean;

import org.springframework.stereotype.Component;

@Component
public class VehicleStatusBean {
	
	private String vehicleId;
	private String status ;
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
