package com.alten.vehiclesservice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alten.vehicles.VehiclesServiceApplication;
import com.alten.vehicles.entity.Customer;
import com.alten.vehicles.repository.ICustomerRepo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehiclesServiceApplication.class)
public class CustomerRepositoryTest {

	@Autowired
	private ICustomerRepo cRepo;

	@Test
	public void givenEmptyDBWhenFindOneByIdThenReturnEmptyOptional() {

		Optional<Customer> foundC = cRepo.findById(1L);

		assertThat(foundC.isPresent()).isEqualTo(false);

	}

	@Test
	public void givenCustomerInDBWhenFindOneByIdThenReturnOptionalWithCustomer() {

		Customer c = new Customer();
		c.setId(1L);
		c.setName("Mostafa");
		c.setAddress("Street 1");
		cRepo.save(c);

		Customer foundC = cRepo.findByName("Mostafa");

		assertThat(null != foundC).isEqualTo(true);
		assertThat(foundC.getName()).isEqualTo(c.getName());

	}

	@Test
	@Transactional
	public void givenCustomersInDBWhenFindAllThenReturnAllCustomers() {

		Customer c = new Customer();
		c.setId(1L);
		c.setName("Malina");
		c.setAddress("Street 1");
		cRepo.save(c);

		Customer c1 = new Customer();
		c.setId(1L);
		c.setName("Bassam");
		c.setAddress("Street 1");
		cRepo.save(c1);

		List<Customer> foundCustomers = cRepo.findAll();
		assertThat(foundCustomers.size()).isEqualTo(2);
		
	}

	@After
	public void cleanUp() {
		cRepo.deleteAll();
	}


}
