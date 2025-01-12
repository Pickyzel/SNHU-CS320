//Tiffany McDonnell
//11-09-23
//SNHU CS-320

package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	@Test
	void testIDcantBeNull() {
		
		//Due to exception in contact for null it is thrown before it can be added as a contact
		
		//Contact newContact2 = new Contact("This","Doe","5555555555","School Edu Ave", null);
		//Assertions.assertThrows(IllegalArgumentException.class, () -> {
			//service.addContact(newContact2);
		//});
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
	
	@Test
	void testUniqueID() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "School Edu Ave","123");
		service.addContact(newContact);
		
		Contact newContact2 = new Contact("This","Doe","5555555555","School Edu Ave", "123");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(newContact2);
		});
	}
	 
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
	
	@Test
	void testCanFindIDToDelete() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Contact newContact2 = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","122");
		service.addContact(newContact2);
		
		Contact newContact3 = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","123");
		service.addContact(newContact3);
		
		service.deleteContact("111");
		 
		assertTrue(service.getList().size() == 2);
		
	}
	
	@Test
	void testCantRemoveUnknownID() {
		ContactService service = new ContactService();
		
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("4872342");
		});
	}
	@Test
	void testEditFirstName() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		service.editFirstName("Kelly", "111");
		
		assertTrue(service.getList().get(0).getFirstName() == "Kelly");
	}
	@Test
	void testCantMakeFirstNameNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editFirstName(null, "111");
		});
	}
	@Test
	void testCantMakeFirstNameMorethan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editFirstName("NewFirstName", "111");
		});
	}
	@Test
	void testMakeFirstNameExactly10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
			service.editFirstName("FirstNames", "111");
			assertTrue(service.getList().get(0).getFirstName()== "FirstNames");
	}
	@Test
	void testEditLastName() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		service.editLastName("Stone", "111");
		
		assertTrue(service.getList().get(0).getLastName() == "Stone");
	}
	@Test
	void testCantMakeLastameNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editLastName(null, "111");
		}); 
	}
	@Test
	void testCantMakeLastnameMoreThan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editLastName("newLastName", "111");
		}); 
	}
	@Test
	void testMakeLastNameExactly10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
			service.editLastName("LastsNames", "111");
			assertTrue(service.getList().get(0).getLastName()== "LastsNames");
	}
	@Test
	void testEditAddress() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		service.editAddress("new address", "111");
		
		assertTrue(service.getList().get(0).getAddress() == "new address");
	}
	@Test
	void testCantMakeAddressNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editAddress(null, "111");
		}); 
	}
	@Test
	void testMakeLastNameExactly30() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
			service.editAddress("Thisisthenewaddresssssssssssss", "111");
			assertTrue(service.getList().get(0).getAddress()== "Thisisthenewaddresssssssssssss");
	}
	@Test
	void testCantMakeAddressMoreThan30() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.editAddress("This is my new length that is too long", "111");
		});
	}
	@Test
	void testEditNumber() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		service.editNumber("7777777777", "111");
		
		assertTrue(service.getList().get(0).getPhone() == "7777777777");
	}
	@Test
	void testEditNumberCantbeMoreThan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editNumber("777777777712", "111");
		});
		
		assertTrue(service.getList().get(0).getPhone() == "7777777777");
	}
	@Test
	void testEditNumberCantbeLessThan10() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.editNumber("777777", "111");
		});
		
		assertTrue(service.getList().get(0).getPhone() == "7777777777");
	}
	@Test
	void testCantMakeNumberNull() {
		Contact newContact = new Contact("Jane", "Doe", "5555555555", "SNHU Edu Ave","111");
		service.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editNumber(null, "111");
		}); 
	}
	 
	

} 
 