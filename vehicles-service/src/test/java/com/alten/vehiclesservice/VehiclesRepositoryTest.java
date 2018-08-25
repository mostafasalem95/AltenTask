package com.alten.vehiclesservice;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Optional;
import com.alten.vehicles.VehiclesServiceApplication;
import com.alten.vehicles.entity.Vehicle;
import com.alten.vehicles.repository.IVehicleRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclesServiceApplication.class)
public class VehiclesRepositoryTest {

	@Autowired
	private IVehicleRepo vRepo;

	@Test
	public void givenEmptyDBWhenFindOneByIdThenReturnEmptyOptional() {

		Optional<Vehicle> foundV = vRepo.findById("1");

		assertThat(foundV.isPresent()).isEqualTo(false);

	}

	@Test
	public void givenVehicleInDBWhenFindOneByIdThenReturnOptionalWithVehicle() {

		Vehicle v = new Vehicle();
		v.setId("1");
		v.setRegNr("abc123");
		v.setStatus("Running");
		vRepo.save(v);

		Optional<Vehicle> foundV = vRepo.findById("1");

		assertThat(foundV.isPresent()).isEqualTo(true);
		assertThat(foundV.get().getRegNr()).isEqualTo(v.getRegNr());

	}

	@Test
	@Transactional
	public void givenVehiclesInDBWhenFindAllThenReturnAllVehicles() {

		Vehicle v = new Vehicle();
		v.setId("1");
		v.setRegNr("abc123");
		v.setStatus("Running");
		vRepo.save(v);

		Vehicle v1 = new Vehicle();
		v1.setId("2");
		v1.setRegNr("abc45");
		v1.setStatus("Stopped");
		vRepo.save(v1);

		List<Vehicle> foundVehicles = vRepo.findAll();
		assertThat(foundVehicles.size()).isEqualTo(2);
		
	}

	@After
	public void cleanUp() {
		vRepo.deleteAll();
	}

}
