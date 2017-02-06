package spring.ws.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import spring.ws.rest.model.Passenger;
import spring.ws.rest.service.PassengerService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/passengers")
public class PassengerController {
	@Autowired
	PassengerService passengerService;

	Passenger passenger;

	@RequestMapping(method = RequestMethod.GET,value="/all")
	public List<Passenger> getAllPassengers() {
		return passengerService.getAllPassengers();
	}

	@RequestMapping(method = RequestMethod.GET, value ="/get")
	public String getPassenger(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "ticketNumber", required = false) String ticketNumber,
			@RequestParam(value = "passportNumber", required = false) String passportNumber,
			@RequestParam(value = "seatNumber", required = false) String seatNumber) {
		passenger = new Passenger(ticketNumber, firstName, lastName, null, 0, passportNumber, seatNumber, null);
		return passengerService.getPassenger(passenger);
	}

	@RequestMapping(method = RequestMethod.POST, value = "update/{ticketNumber}" )
	public String updatePassenger(@PathVariable(value = "ticketNumber", required = true) String ticketNumber,
			@RequestHeader(value = "passportNumber", required = false) String passportNumber,
			@RequestHeader(value = "seatNumber", required = false) String seatNumber,
			@RequestHeader(value = "mealType", required = false) String mealType,
			@RequestHeader(value = "age", required = false) String age,
			@RequestHeader(value = "gender", required = false) String gender,
			@RequestHeader(value = "firstName", required = false) String firstName,
			@RequestHeader(value = "lastName", required = false) String lastName) {
		int newAge=0;
		if(age!=null)
		newAge=	Integer.parseInt(age);
		passenger = new Passenger(ticketNumber, firstName, lastName, gender, newAge, passportNumber, seatNumber, mealType);
		return passengerService.updatePassenger(passenger);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/add" )
	public Passenger addPassenger(@RequestHeader(value = "firstName", required = true) String firstName,
			@RequestHeader(value = "lastName", required = false) String lastName,
			@RequestHeader(value = "passportNumber", required = true) String passportNumber,
			@RequestHeader(value = "seatNumber", required = true) String seatNumber,
			@RequestHeader(value = "mealType", required = false) String mealType,
			@RequestHeader(value = "age", required = true) String age,
			@RequestHeader(value = "gender", required = true) String gender) {
		passenger = new Passenger(null, firstName, lastName, gender, Integer.parseInt(age), passportNumber, seatNumber, mealType);
		return passengerService.addPassenger(passenger);
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/deleteAll")
	public List<Passenger> deleteAllPassengers() {
		return passengerService.deleteAllPassengers();
	}
}