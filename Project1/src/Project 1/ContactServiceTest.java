//Tiffany McDonnell
//11-09-23
//SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.Contact;
import app.ContactService;

class ContactServiceTest {
	ContactService service = new ContactService();

	//Tests if a contact can be added;
	@Test
	void testContactServiceAdd() {

		Contact newContact = new Contact("Jane", "Doe", "5555555555", "School Edu Ave","1");
		service.addContact(newContact);
		
		assertTrue(service.getList().get(0).getFirstName() == "Jane");
		assertTrue(service.getList().get(0).getLastName() == "Doe");
		assertTrue(service.getList().get(0).getPhone() == "5555555555");
		assertTrue(service.getList().get(0).getAddress() == "School Edu Ave");
		assertTrue(service.getList().get(0).getID() == "1");
		
	}
	
	//Tests if more than 1 contact can be added
	@Test
	void testAddsMoreThan1() {	 
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "School Edu Ave","1");
		service.addContact(newContact);
		
		Contact newContact2 = new Contact("Jane", "Doe", "5555555555", "School Edu Ave","2");
		service.addContact(newContact2);
		assertTrue(service.getList().size() > 0);
	}
	
	//tests that IDs in list are unique
	@Test
	void testUniqueID() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "School Edu Ave","123");
		service.addContact(newContact);
		
		Contact newContact2 = new Contact("This","Doe","5555555555","School Edu Ave", "123");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(newContact2);
		});
	}
	 
	//tests that null id can not be deleted
	@Test
	void testCantRemoveNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(null);
		});
	}
	
	//Tests if contact can be deleted
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "School Edu Ave","123");
		service.addContact(newContact);
		service.deleteContact("123");

	}
	
	//tests that unique id can be found within a list for deletion
	@Test
	void testCanFindIDToDelete() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Contact newContact2 = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","122");
		service.addContact(newContact2);
		
		Contact newContact3 = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","123");
		service.addContact(newContact3);
		
		service.deleteContact("111");
		 
		assertTrue(service.getList().size() == 2);
		
	}
	
	//tests edit first name
	@Test
	void testEditFirstName() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		service.editFirstName("Kelly", "111");
		
		assertTrue(service.getList().get(0).getFirstName() == "Kelly");
	}
	
	//tests that first name can not be changed to null
	@Test
	void testCantMakeFirstNameNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editFirstName(null, "111");
		});
	}
	
	//tests that first name can not be changed to a name more than 10 char.
	@Test
	void testCantMakeFirstNameMorethan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editFirstName("NewFirstName", "111");
		});
	}
	
	//tests that first name can be changed to exactly 10 char.
	@Test
	void testMakeFirstNameExactly10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
			service.editFirstName("FirstNames", "111");
			assertTrue(service.getList().get(0).getFirstName()== "FirstNames");
	}
	
	//tests edit last name
	@Test
	void testEditLastName() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		service.editLastName("Stone", "111");
		
		assertTrue(service.getList().get(0).getLastName() == "Stone");
	}
	
	//tests that last name can not be edited to null
	@Test
	void testCantMakeLastameNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editLastName(null, "111");
		}); 
	}
	
	//tests that can not change last name to more than 10 char
	@Test
	void testCantMakeLastnameMoreThan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editLastName("newLastName", "111");
		}); 
	}
	
	//tests that last name can be changed to exactly 10 char
	@Test
	void testMakeLastNameExactly10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
			service.editLastName("LastsNames", "111");
			assertTrue(service.getList().get(0).getLastName()== "LastsNames");
	}
	
	//tests edit address
	@Test
	void testEditAddress() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		service.editAddress("new address", "111");
		
		assertTrue(service.getList().get(0).getAddress() == "new address");
	}
	
	//tests that address can not be changed to null
	@Test
	void testCantMakeAddressNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editAddress(null, "111");
		}); 
	}
	
	//tests that Address  can be changed to exactly 30 char 
	@Test
	void testMakeAddressExactly30() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
			service.editAddress("Thisisthenewaddresssssssssssss", "111");
			assertTrue(service.getList().get(0).getAddress()== "Thisisthenewaddresssssssssssss");
	}
	
	//tests that exception is throw if address is edited to more than 30 char
	@Test
	void testCantMakeAddressMoreThan30() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.editAddress("This is my new length that is too long", "111");
		});
	}
	
	//test edit number
	@Test
	void testEditNumber() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		service.editNumber("7777777777", "111");
		
		assertTrue(service.getList().get(0).getPhone() == "7777777777");
	}
	
	//tests edited number can not be more than 10 char
	@Test
	void testEditNumberCantbeMoreThan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		//if exception is thrown test works
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editNumber("777777777712", "111");
		});
		
	}
	
	//tests edited number can not be less than 10 char
	@Test
	void testEditNumberCantbeLessThan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.editNumber("777777", "111");
		});
	}
	
	//tests that edited number can not be changed to null
	@Test
	void testCantMakeNumberNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "school Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editNumber(null, "111");
		}); 
	}
	 
	

} 
  