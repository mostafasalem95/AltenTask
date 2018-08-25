package com.alten.vehicles.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alten.vehicles.status.bean.VehicleStatusBean;

@FeignClient(name="vehicle-gateway-service")
@RibbonClient(name="vehicle-gateway-service")
public interface VehicleStatusServiceProxy {

	@GetMapping("/api/vss/getVehicleStatus/{vehicleId}")
	public VehicleStatusBean getVehicleStatus(@PathVariable("vehicleId") String vehicleId);
	
}
