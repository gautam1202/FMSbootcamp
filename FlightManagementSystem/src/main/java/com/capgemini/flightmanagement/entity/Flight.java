package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="flight_table")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger flightId;
	
	@NotNull(message="carrier name cannot be null")
	@Size(min=4,max=14,message="carrier name must be between 4 and 14 characters")
	@Column(name = "carrier_name", length = 30)
	private String carrierName;
	
	@NotNull(message="flight model cannot be null")
	@Size(min=5,max=5,message="flight model must be of 5 characters")
	@Column(name = "flight_model", length = 30)
	private String flightModel;
	
	@Min(value = 10, message = "Capacity should not be less than 10")
	@Max(value = 900, message = "Capacity should not be greater than 900")
	@Column(name = "seat_capacity", length = 30)
	private int seatCapacity;
	
	
	public Flight() {
	}


	public Flight(BigInteger flightId, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightId = flightId;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}


	public BigInteger getFlightId() {
		return flightId;
	}

	public void setFlightId(BigInteger flightId) {
		this.flightId = flightId;
	}


	public String getCarrierName() {
		return carrierName;
	}

	
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ",carrierName=" + carrierName + ",flightModel=" + flightModel
				+ ",seatCapacity=" + seatCapacity + "]";
	}

	
}