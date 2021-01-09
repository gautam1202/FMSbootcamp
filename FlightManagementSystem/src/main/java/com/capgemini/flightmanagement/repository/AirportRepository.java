package com.capgemini.flightmanagement.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, BigInteger>{

	

}