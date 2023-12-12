//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.Contact;

class ContactTest {

	//Tests That contact can be successfully created
	@Test
	void testContact() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertTrue(contact.getFirstName().equals("Jane"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getID().equals("1"));
		assertTrue(contact.getPhone().equals("5555555555"));
		assertTrue(contact.getAddress().equals("School Edu Ave"));	
	}
	
	//Tests that no contact can be created with 10 character first name(no exception thrown)
	@Test
	void testContactFirstNameIsEqualLength() {
		Contact contact = new Contact("JaneIs10OK","Doe","5555555555","School Edu Ave","1");
		assertTrue(contact.getFirstName().length() == 10);
	}
	
	//Tests exception is thrown when first name is more than 10 characters
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("ThisIsJaneDoeTooLong","Doe","5555555555","School Edu Ave", "1");});
	}
	
	//Tests that contact is created with less than 10 character first name(no exception thrown)
	@Test
	void testContactFirstNameLessThan10() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertTrue(contact.getFirstName().length() < 10);
	}
	
	//Tests contact is created and first name is not null after creation
	@Test
	void testContactFirstNameNotNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertNotNull(contact.getFirstName());
	}
	
	//Tests that exception is thrown if first name is null
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null,"Doe","5555555555","School Edu Ave","1");
		});
	}
	
	//Tests First Name can be changed
	@Test
	void testChangeFirstName() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertTrue(contact.getFirstName() == "Jane");
		contact.setFirstName("NewName");
		assertTrue(contact.getFirstName() == "NewName");
	}
	
	//Tests First Name cannot be changed to null
	@Test
	void testChangeFirstNameToNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	 
	//Tests that no contact can be created with 10 character last name(no exception thrown)
	@Test
	void testContactLastNameIsEqualLength() {
		Contact contact = new Contact("Jane","DoeisLast1","5555555555","School Edu Ave","1");
		assertTrue(contact.getLastName().length() == 10);
	}
	
	//Tests exception is thrown when last name is more than 10 characters
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Jane","DoeisToLongNow","5555555555","school Edu Ave","1");
		});
	}
	
	//Tests that contact is created with less than 10 character last name(no exception thrown)
	@Test
	void testContactLastNameLessThan10() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertTrue(contact.getLastName().length() < 10);
	}
	
	//Tests contact is created and last name is not null after creation
	@Test
	void testContactLastNameNotNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertNotNull(contact.getLastName());
	}
	
	//Tests that exception is thrown if last name is null
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Jane",null,"5555555555","School Edu Ave","1");
		});
	}
	
	//Tests Last name can be changed
	@Test
	void testLastNameChange() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1" );
		assertTrue(contact.getLastName() == "Doe");
		contact.setLastName("NewName");
		assertTrue(contact.getLastName() == "NewName");
	}
	
	//Tests Last Name cannot be changed to null
	@Test
	void testChangeLastNameToNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave" ,"1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
	}
	
	//Tests that new contact can be created with 30 character address(no exception thrown)
	@Test
	void testContactAddressIsEqualLength() {
		Contact contact = new Contact("Jane","Doe","5555555555","Schl New-Edu Ave New Townships","1");
		assertTrue(contact.getAddress().length() == 30);
	}
	
	//Tests exception is thrown when address is more than 30 characters
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Jane","Doe","5555555555","NOPE New-Edu Ave New Township is too long now","1");
		});
	}
	
	//Tests that contact is created with less than 30 character last name(no exception thrown)
	@Test
	void testContactAddressLessThan30() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertTrue(contact.getLastName().length() < 30);
	}
	
	//Tests contact is created and address is not null after creation
	@Test
	void testContactAddressNotNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1" );
		assertNotNull(contact.getAddress());
	}
	
	//Tests that exception is thrown if address is null
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Jane","Doe","5555555555",null,"1");
		});
	}
	
	//Tests Address cannot be changed to null
	@Test
	void testChangeAddressToNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
	
	//Tests Address Can be changed
	@Test
	void testContactAddressCanBeChanged() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave" ,"1");
		assertTrue(contact.getAddress() == "School Edu Ave");
		contact.setAddress("NewAddress");
		assertTrue(contact.getAddress() == "NewAddress");
	}
	
	//Tests that ID is not more than 10 characters, created
	@Test
	void testContactIDnotMoreThan10() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("Jane","Doe","5555555555","School Edu Ave" ,"10101010101");});
		
	}
	
	//Tests that ID is not can not be null,
	@Test
	void testContactIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("Jane","Doe","5555555555","School Edu Ave" ,null);});
		
	}
	//Tests that ID is are less than 10 characters so can be created
	@Test
	void testContactIDnotLessThan10() {
			Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave" ,"1010");
			assertTrue(contact.getID() == "1010");
		
	}
	
	//Tests that ID is are less than 10 characters so can be created
	@Test
	void testContactIDis10() {
			Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave" ,"1010101010");
			assertTrue(contact.getID() == "1010101010");
		
	}
	
	//Tests contact is created and ID is not null after creation
	@Test
	void testContactIDNotNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1");
		assertNotNull(contact.getID());
	}
	
	//Tests that new contact can be created with 10 character phone number(no exception thrown)
	@Test
	void testContactNumberIsEqualLength() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1" );
		assertTrue(contact.getPhone().length() == 10);
	}
		
	//Tests exception is thrown when phone number is more than 10 characters
	@Test
	void testContactNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Jane","Doe","55555555555","School Edu Ave","1");
		});
	}
		
	//Tests that contact cannot be created with less than 10 character phone number
	void testContactNumberLessThan10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("Jane","Doe","55555555","School Edu Ave","1");});
	}
		
	//Tests contact is created and phone number is not null after creation
	@Test
	void testContactNumberNotNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave" ,"1");
		assertNotNull(contact.getPhone());
	}
	
	//Tests contact phone number Throws exception if null
	@Test
	void testContactNumberisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Jane","Doe",null,"School Edu Ave","1");
			});
	}
	
	
	//Tests can change phone number
	@Test
	void testChangeNumber() {
		Contact contact = new Contact("Jane","Doe","5555555555","School Edu Ave","1" );
		assertTrue(contact.getPhone() == "5555555555");
		contact.setPhone("1111111111");
		assertTrue(contact.getPhone() == "1111111111");
	}
	
	//Tests phone number cannot be changed to null
	@Test
	void testChangePhoneToNull() {
		Contact contact = new Contact("Jane","Doe","5555555555","school Edu Ave" ,"1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> { contact.setPhone(null);	});
	}
} 
