package spring.ws.rest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import spring.ws.rest.model.Passenger;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Passenger addPassenger(Passenger passenger) {
		return entityManager.merge(passenger);	
	}
	
	@Override
	public List<Passenger> getAllPassengers() {
		return (List<Passenger>) entityManager.createQuery("SELECT e FROM Passenger e").getResultList();
	}
	
	@Override
	public String updatePassenger(Passenger passenger) {
	List<Passenger> passengerList=	(List<Passenger>)entityManager.createQuery("SELECT e FROM Passenger e WHERE ticketNumber =:ticketNbr").setParameter("ticketNbr", passenger.getTicketNumber()).getResultList();
	Passenger editPassenger=passengerList.get(0);
	if (passenger.getFirstName() == null)
		passenger.setFirstName(editPassenger.getFirstName());
	if (passenger.getLastName() == null)
		passenger.setLastName(editPassenger.getLastName());
	if (passenger.getGender() == null)
		passenger.setGender(editPassenger.getGender());
	if (passenger.getSeatNumber() == null)
		passenger.setSeatNumber(editPassenger.getSeatNumber());
	if (passenger.getPassportNumber() == null)
		passenger.setPassportNumber(editPassenger.getPassportNumber());
	if (passenger.getAge() ==0)
		passenger.setAge(editPassenger.getAge());
	if (passenger.getMealType()== null)
		passenger.setMealType(editPassenger.getMealType());
		
	return ((Passenger)entityManager.merge(passenger)).toString();
	}

	@Override
	public String getPassenger(Passenger passenger) {
		Boolean queryParam=false;
		String SQL="SELECT e FROM Passenger e WHERE ";
		if (passenger.getFirstName() != null) {
			SQL=SQL.concat("firstName =:firstName and ");
			queryParam=true;
		}
		if (passenger.getLastName() != null) {
			SQL=SQL.concat("lastName =:lastName and ");
			queryParam=true;
		}
		if (passenger.getTicketNumber() != null) {
			SQL=SQL.concat("ticketNumber =:ticketNbr and ");
			queryParam=true;
		}
		if (passenger.getSeatNumber() != null) {
			SQL=SQL.concat("seatNumber =:seatNbr and ");
			queryParam=true;
		}
		if (passenger.getPassportNumber() != null) {
			SQL=SQL.concat("passportNumber =:passportNbr and ");
			queryParam=true;
		}
		SQL = SQL.substring(0, SQL.length()-4);
		if(queryParam){
			TypedQuery<Passenger> query = entityManager.createQuery(SQL, Passenger.class);

			if (passenger.getFirstName() != null) {
				query.setParameter("firstName", passenger.getFirstName());
			}
			if (passenger.getLastName() != null) {
				query.setParameter("lastName", passenger.getLastName());
			}
			if (passenger.getTicketNumber() != null) {
				query.setParameter("ticketNbr", passenger.getTicketNumber());
			}
			if (passenger.getSeatNumber() != null) {
				query.setParameter("seatNbr", passenger.getSeatNumber());
			}
			if (passenger.getPassportNumber() != null) {
				query.setParameter("passportNbr", passenger.getPassportNumber());
			}
		   return query.getResultList().get(0).toString();
		}
		return null;
	}

	@Override
	public List<Passenger> deleteAllPassengers() {
		entityManager.createQuery("DELETE FROM Passenger").executeUpdate();
		return (List<Passenger>) entityManager.createQuery("SELECT e FROM Passenger e").getResultList();
	}

}