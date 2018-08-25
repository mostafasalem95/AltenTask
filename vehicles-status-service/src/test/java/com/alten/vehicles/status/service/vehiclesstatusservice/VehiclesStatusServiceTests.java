package com.alten.vehicles.status.service.vehiclesstatusservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.alten.vehicles.status.VehiclesStatusServiceApplication;
import com.alten.vehicles.status.bean.VehicleStatusBean;
import com.alten.vehicles.status.service.VehicleStatusService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclesStatusServiceApplication.class)
public class VehiclesStatusServiceTests {
	
	@Autowired
    private VehicleStatusService vService;
	
	@Test
	public void checkVehicleStatus() {
		VehicleStatusBean vb = vService.getVehicleStatus("YS2R4X20005399401");
		assertThat(null != vb).isEqualTo(true);
		assertThat(vb.getVehicleId()).isEqualTo("YS2R4X20005399401");
		assertThat("Stopped".equals(vb.getStatus().trim()) || "Running".equals(vb.getStatus().trim())).isEqualTo(true);
	}
	
	

}
