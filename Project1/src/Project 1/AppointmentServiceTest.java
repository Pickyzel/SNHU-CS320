//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package test;
 
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import apps.Appointment;
import apps.AppointmentService;

class AppointmentServiceTest {
	
	AppointmentService service = new AppointmentService();

	@Test
	void testAddAppointment() {
	
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		assertTrue(service.getList().get(0).getDate() == myDate);
		assertTrue(service.getList().get(0).getDescription() == "MyDescription");
		assertTrue(service.getList().get(0).getId() == "12345");
	}
	
	//add appointment	//also proves not null
	@Test
	void testAddAppointmentToList() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		assertNotNull(appt.getId());
		assertNotNull(appt.getDescription());
		
		assertTrue(service.getList().contains(appt));
	}
	
	//add appointment with not null date
	@Test
	void testAddAppointmentNotNullDate() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		assertNotNull(appt.getDate());
	}
	

	
	//add appointment with date at current
	@Test
	void testAddAppointmentWithCurrentDate() {
		Date myDate = new Date();
		Date curDate = myDate;
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		assertTrue(service.getList().get(0).getDate() == curDate);
	}
	
	//add appointment with date after current
	@Test
	void testAddAppointmentWithDateFutureDate() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		//proves can be added with future date without exception
		assertTrue(service.getList().contains(appt));
	}
	
	//add multiple appointment
	@Test
	void testAddAppointmentMulitple() {
	//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		Appointment appt2 = new Appointment(myDate, "NewONe", "12354");
		service.addApp(appt);
		service.addApp(appt2);
		
		assertTrue(service.getList().size()==2);
	}
	
	//add try with same id validates unique ID
	@Test
	void testAddAppointmentWithSameIds() {
	//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		Appointment appt2 = new Appointment(myDate, "NewONe", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addApp(appt2);
	});

	}
	
	//remove from appointment list
	@Test
	void testRemoveFromList() { 
	//create appointment
		AppointmentService service = new AppointmentService();
		
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		assertTrue(service.getList().contains(appt));
		service.deleteAppt("12345");
		
		assertFalse(service.getList().contains(appt));
	}
	
	//remove from appointment 
	@Test
	void testRemoveFromMultiAppointment() {
	//create appointment
		AppointmentService service = new AppointmentService();
		
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		@SuppressWarnings("deprecation")
		Date myDate2 = new Date(2025,10,11);
		@SuppressWarnings("deprecation")
		Date myDate3 = new Date(2025,10,12);
		
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		assertTrue(service.getList().contains(appt));
		
		Appointment appt3= new Appointment(myDate2, "MyDescription", "12347");
		service.addApp(appt3);
		assertTrue(service.getList().contains(appt3));
		
		Appointment appt2 = new Appointment(myDate3, "MyDescription", "12348");
		service.addApp(appt2);
		assertTrue(service.getList().contains(appt2));
		service.deleteAppt("12345");
		
		assertTrue(service.getList().size()== 2);
	}
	
	//remove with null id
	@Test
	void testRemoveAppointmentWithNullId() {
	//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppt(null);
	});
	}
	
	
	@Test
	void testUpdateDescription() {
		
		AppointmentService service = new AppointmentService();
		
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		service.editDescription("This Is The new Description", "12345");
		
		assertTrue(service.getList().get(0).getDescription() == "This Is The new Description");		
		
	}	
	
	@Test
	void testUpdateDescriptionWithTooManyChar() {
		
		AppointmentService service = new AppointmentService();
		
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.editDescription("This Is The new Description.................................", "12345");
		});
		
	}	
	
	@Test
	void testUpdateDescriptionWithExactly50Char() {
		
		AppointmentService service = new AppointmentService();
		
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		service.editDescription("This Is The new Description.......................", "12345");
		assertTrue(service.getList().get(0).getDescription() == "This Is The new Description.......................");
		
	}	
	
	@Test
	void testUpdateDescriptionWithNullID() {
		
		//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription("newDes",null);
	});
	}
	
	@Test
	void testUpdateDescriptionWithNullDescription() {

		AppointmentService service = new AppointmentService();
		
		//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription(null,"12345");
	});
	}
	
	@Test
	void testUpdateDate() {
		
		AppointmentService service = new AppointmentService();
		
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		@SuppressWarnings("deprecation")
		Date newDate = new Date(2025,11,11);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		service.editDate(newDate, "12345");
		
		assertTrue(service.getList().get(0).getDate() == newDate);
	}	
	
	@Test
	void testUpdateDateWithFutureDate() {
		
		AppointmentService service = new AppointmentService();

		//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		@SuppressWarnings("deprecation")
		Date futureDate = new Date(2030,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		service.editDate(futureDate, "12345");
		
		assertTrue(service.getList().get(0).getDate() == futureDate);
	}
	
	@Test
	void testUpdateDateWithBeforeCurrentDate() {
		
		AppointmentService service = new AppointmentService();

		//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		@SuppressWarnings("deprecation")
		Date beforeDate = new Date(100,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.editDate(beforeDate, "12345");
		});
		
	}
	
	@Test
	void testUpdateDateWithNullID() {
		
		AppointmentService service = new AppointmentService();

		//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		@SuppressWarnings("deprecation")
		Date newDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDate(newDate,null);
	});
	}
	
	@Test
	void testUpdateDateWithNullDate() {

		AppointmentService service = new AppointmentService();
		
		//create appointment
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt= new Appointment(myDate, "MyDescription", "12345");
		service.addApp(appt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDate(null,"12345");
	});
	}	
}
