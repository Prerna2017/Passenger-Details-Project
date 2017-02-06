package spring.ws.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "Passenger", uniqueConstraints = {@UniqueConstraint(columnNames = "ticketNumber")})
public class Passenger implements Serializable {
	private static final long serialVersionUID = -1798070786993154676L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String ticketNumber;
	@Column(name = "firstname")
	String firstName;
	@Column(name = "lastname")
	String lastName;
	@Column(name = "gender")
	String gender;
	@Column(name = "age")
	int age;
	@Column(name = "passportnumber")
	String passportNumber;
	@Column(name = "seatnumber")
	String seatNumber;
	@Column(name = "mealtype")
	String mealType;

	public Passenger() {
		super();
	}

	public Passenger(String ticketNumber, String firstName, String lastName, String gender, int age,
			String passportNumber, String seatNumber, String mealType) {
		super();
		this.ticketNumber = ticketNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.passportNumber = passportNumber;
		this.seatNumber = seatNumber;
		this.mealType = mealType;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (ticketNumber == null) {
			if (other.ticketNumber != null)
				return false;
		} else if (!ticketNumber.equals(other.ticketNumber))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"ticketNumber\":\""+this.ticketNumber + "\",\"firstName\":\"" + this.firstName + "\",\"lastName\":\"" + this.lastName
				+ "\",\"gender\":\"" + this.gender + "\",\"age\":\"" + this.age + "\",\"passportNumber\":\"" + this.passportNumber 
				+ "\",\"seatNumber\":\""+this.seatNumber + "\",\"mealType\":\""+this.mealType+"\"}";
	}
}