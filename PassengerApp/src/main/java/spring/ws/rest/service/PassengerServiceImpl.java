package spring.ws.rest.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.ws.rest.service.PassengerService;
import spring.ws.rest.dao.PassengerDAO;
import spring.ws.rest.model.Passenger;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDAO passengerDao;
	
	@Override
	public String updatePassenger(Passenger passenger) {
		return passengerDao.updatePassenger(passenger);
	}

	@Override
	public  List<Passenger> getAllPassengers(){
		return passengerDao.getAllPassengers();
	}

	@Override
	public  String getPassenger(Passenger passenger){
		return passengerDao.getPassenger(passenger);
	}

	@Override
	public  Passenger addPassenger(Passenger passenger){
		return passengerDao.addPassenger(passenger);
	}
	
	@Override
	public  List<Passenger> deleteAllPassengers(){
		return passengerDao.deleteAllPassengers();
	}
}
