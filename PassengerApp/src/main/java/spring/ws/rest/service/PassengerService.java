package spring.ws.rest.service;

import java.util.List;

import spring.ws.rest.model.Passenger;

public interface PassengerService {

	public String updatePassenger(Passenger passenger) ;

	public  List<Passenger> getAllPassengers();
	
	public  String getPassenger(Passenger passenger);
	
	public  Passenger addPassenger(Passenger passenger);

	public  List<Passenger> deleteAllPassengers();
}
