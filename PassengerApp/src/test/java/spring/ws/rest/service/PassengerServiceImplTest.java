package spring.ws.rest.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;

import spring.ws.rest.HibernateUtil;
import spring.ws.rest.model.Passenger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassengerServiceImplTest {
	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	private PassengerService passengerService;

	private static final String CREATE_PASSENGER_T_SQL_SCRIPT = "passenger-create.sql";
	private static final String DROP_PASSENGER_T_SQL_SCRIPT = "passenger-drop.sql";

	/*@Before
	public void before() throws ScriptException, SQLException {
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(),
				new ClassPathResource(DROP_PASSENGER_T_SQL_SCRIPT));
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(),
				new ClassPathResource(CREATE_PASSENGER_T_SQL_SCRIPT));
	}*/

	@Test
	public void addPassengerTest() {
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Passenger passenger = new Passenger(null, "Rahul", null, null, 0, null, null, null);
		int count=passengerService.getPassenger(passenger).size();
		System.out.println("count ::"+count);
		Passenger passenger2 = new Passenger("", "Rahul", "Sharma", "M", 29, "A1126345", "K34", "Vegetarian");
		passengerService.addPassenger(passenger2);
		assertEquals(++count,passengerService.getPassenger(passenger).size());
		passengerService.addPassenger(passenger2);
		assertEquals(++count,passengerService.getPassenger(passenger).size());
		session.getTransaction().commit();
		HibernateUtil.shutdown();*/
		}

	/*@After
	public void after() throws ScriptException, SQLException {
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(),
				new ClassPathResource(DROP_PASSENGER_T_SQL_SCRIPT));
	}*/

}