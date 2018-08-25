package com.alten.vehicles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.vehicles.entity.Vehicle;

public interface IVehicleRepo extends JpaRepository<Vehicle, String> {

	public Optional<Vehicle> findById(String id);
	public Optional<Vehicle> findOneByStatus(String status); 
	
}
