package com.alten.vehiclesservice;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.alten.vehicles.VehiclesServiceApplication;
import com.alten.vehicles.entity.Customer;
import com.alten.vehicles.service.VehicleService;
import com.alten.vehicles.status.bean.VehicleStatusBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclesServiceApplication.class)
public class VehiclesServiceTests {
	
	
	@Autowired
    private VehicleService vService;

	
	@Test
	public void checkCustomerList() {
		List<Customer> c = vService.getAllCustomers();
		assertThat(null != c).isEqualTo(true);
		assertThat(c.size() > 0).isEqualTo(true);
	}
	
	@Test
	public void checkIfCustomerHasVehicle() {
		List<Customer> c = vService.getAllCustomers();
		assertThat(null != c.get(0).getVehicle()).isEqualTo(true);
		assertThat(c.get(0).getVehicle().size() > 0).isEqualTo(true);
	}

	@Test
	public void checkVehicleStatusDataIsValid() {
		VehicleStatusBean vb = vService.getVehicleStatus("YS2R4X20005399401");
		assertThat(null != vb).isEqualTo(true);
		assertThat(vb.getVehicleId()).isEqualTo("YS2R4X20005399401");
		assertThat(!"".equals(vb.getStatus().trim())).isEqualTo(true);
	}


}
