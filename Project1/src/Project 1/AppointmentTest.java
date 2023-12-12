//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package test;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.Appointment;

class AppointmentTest {

	@Test //create appointment
	void testCreateAppointment() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		
		assertTrue(appt.getDate().equals(myDate));
		assertTrue(appt.getDescription().equals("myDescription"));
		assertTrue(appt.getId().equals("12345"));
	}
	
	//create appointment with null date
	@Test 
	void testCreateAppointmentNullDate() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Appointment appt = new Appointment(null, "myDescription","12345");
		});
	}
	
	//create appointment with not null date
	@Test 
	void testCreateAppointmentNotNullDate() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		
		assertNotNull(appt.getDate());
	}
	
	//create appointment with null id
	@Test 
	void testCreateAppointmentNullId() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Appointment appt = new Appointment(myDate, "myDescription",null);
		});
	}
	
	//create appointment with not null id
	@Test 
	void testCreateAppointmentNotNullId() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		
		assertNotNull(appt.getId());
	}
	
	//create appointment with null description
	@Test 
	void testCreateAppointmentNullDescription() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Appointment appt = new Appointment(myDate, null,"12345");
		});
	}
	
	//create appointment with not null description
	@Test 
	void testCreateAppointmentNotNullDescription() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		
		assertNotNull(appt.getDescription());
	}
	
	//create appointment with date before current
	@Test 
	void testCreateAppointmentBeforeCurrent() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(100,10,10);
		 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appt = new Appointment(myDate, "myDescription","12345");
		});
	}
	
	//create appointment with date at current 
	@Test 
	void testCreateAppointmentDateExact() {
		Date myDate = new Date();
		Date curDate = myDate;
		
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		assertTrue(appt.getDate().equals(curDate));
	}
	
	//create appointment with date after current
	@Test 
	void testCreateAppointmentDateFuture() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2025,10,10);
		
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		//the fact the object was made proves it works
		assertTrue(appt.getId().equals("12345"));

	}
	
	//create appointment with id greater than 10
	@Test 
	void testCreateAppointmentIdGreater() {
		@SuppressWarnings("deprecation")
		Date myDate = new Date(2000,10,10);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Appointment appt = new Appointment(myDate, "myDescription","12345123456789");
		});
	}
	
	//create appointment with id less than 10
	@Test 
	void testCreateAppointmentIdLess() {
		Date myDate = new Date();
		
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		//the fact the object was made proves it works
		assertTrue(appt.getId().equals("12345"));
	}
	
	//create appointment with id at 10
	@Test 
	void testCreateAppointmentIdExact() {
		Date myDate = new Date();
		
		Appointment appt = new Appointment(myDate, "myDescription","1234512345");
		//the fact the object was made proves it works
		assertTrue(appt.getId().equals("1234512345"));
	}
	
	
	//create appointment with description greater than 50
	@Test 
	void testCreateAppointmentDescriptionGreater() {
		Date myDate = new Date();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Appointment appt = new Appointment(myDate, "myDescriptionIsHereToProveThatTheCharaterCountCanNotBeMoreThanFifty","12345");
		//the fact the object was made proves it works
		});
	}
	 
	//create appointment with description at 50
	@Test 
	void testCreateAppointmentDescriptionExact() {
		Date myDate = new Date();
		
		Appointment appt = new Appointment(myDate, "myDescription.....................................","12345");
		//the fact the object was made proves it works
		assertTrue(appt.getId().equals("12345"));
	}
	
	//create appointment with description less than 50
	@Test 
	void testCreateAppointmentDescriptionLess() {
Date myDate = new Date();
		
		Appointment appt = new Appointment(myDate, "myDescription","12345");
		//the fact the object was made proves it works
		assertTrue(appt.getId().equals("12345"));
	}

}
