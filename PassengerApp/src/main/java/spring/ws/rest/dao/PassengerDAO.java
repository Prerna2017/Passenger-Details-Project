package spring.ws.rest.dao;

import java.util.List;

import spring.ws.rest.model.Passenger;

public interface PassengerDAO {

	public Passenger addPassenger(Passenger passenger);
	
	public String updatePassenger(final Passenger passenger) ;
	
	public  List<Passenger> getAllPassengers();
	
	public  String getPassenger(Passenger passenger);

	public  List<Passenger> deleteAllPassengers();
}
