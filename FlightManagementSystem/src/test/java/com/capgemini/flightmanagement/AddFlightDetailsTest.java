//package com.capgemini.flightmanagement;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.capgemini.flightmanagement.entity.Flight;
//import com.capgemini.flightmanagement.repository.FlightRepository;
//import com.capgemini.flightmanagement.service.FlightServiceImpl;
//
//@SpringBootTest
//public class AddFlightDetailsTest {
//
//	
//	@Autowired
//	private FlightServiceImpl flightService;
//	
//	@MockBean
//	private FlightRepository repository;
//	
//	
//	
//	@Test
//	public void testAddFlightDetails() {
//		
//		Flight flightObj = new Flight("Air India","Boeing","A3212",12);
//		when(repository.save(flightObj)).thenReturn(flightObj);
//		assertEquals(flightObj, flightService.addFlightDetails(flightObj));
//	}
//	
//}
