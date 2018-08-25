package com.alten.vehicles.status.service.vehiclesstatusservice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.alten.vehicles.status.VehiclesStatusServiceApplication;
import com.alten.vehicles.status.bean.VehicleStatusBean;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclesStatusServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class VehicleStatusControllerTest {

	private String resourceUrl;
	
	@Value("${local.server.port}")
	int port;
	
	@Before
    public void setup() {
        resourceUrl = "http://localhost:" + port + "/";
    }

	@Test
	public void checkVehicleStatusResponse() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<VehicleStatusBean> response = restTemplate
				.getForEntity(resourceUrl+ "getVehicleStatus/YS2R4X20005399401", VehicleStatusBean.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(!"".equals(response.getBody().toString().trim())).isEqualTo(true);
	}
	
	@Test
	public void checkVehicleStatusData() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<VehicleStatusBean> response = restTemplate
				.getForEntity(resourceUrl+ "getVehicleStatus/YS2R4X20005399401", VehicleStatusBean.class);
		VehicleStatusBean vb = response.getBody();
		assertThat(null != vb).isEqualTo(true);
		assertThat(vb.getVehicleId()).isEqualTo("YS2R4X20005399401");
		assertThat("Stopped".equals(vb.getStatus().trim()) || "Running".equals(vb.getStatus().trim())).isEqualTo(true);
	}

}
