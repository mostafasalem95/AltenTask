package com.alten.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.vehicles.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

	public Customer findByName(String name);
	
}
