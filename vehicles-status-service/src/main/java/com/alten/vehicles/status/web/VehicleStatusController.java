package com.alten.vehicles.status.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alten.vehicles.status.bean.VehicleStatusBean;
import com.alten.vehicles.status.service.VehicleStatusService;


@RestController
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vs;
	
	@GetMapping("/getVehicleStatus/{vehicleId}")
	public VehicleStatusBean getVehicleStatus(@PathVariable String  vehicleId) {
		return vs.getVehicleStatus(vehicleId);
	}

}
