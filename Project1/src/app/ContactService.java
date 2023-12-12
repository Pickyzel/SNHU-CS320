//Tiffany McDonnell
//11-09-23
//SNHU CS-320

package app;

import java.util.ArrayList;
import java.util.List;


//ContactService class used to create, delete, and update Contacts in the contact book
public class ContactService {
	
	//list created to hold contacts
	private static List<Contact> contactBook =  new ArrayList<Contact>();
	
  	public ContactService() {
		contactBook = new ArrayList<Contact>();
	}
	
	//method used to add contacts to contactBook
	public void addContact(Contact contact) {
		
		//Used to compare IDs to make sure IDs stay unique
		for (int i = 0; i < contactBook.size(); i++) {
			
			if (contact.getID()== (contactBook.get(i).getID())) {
				throw new IllegalArgumentException("Invalid ID");
			}
		}
		//Contact contact = new Contact(newFirstName, newLastName, number, newAddress, newID);
		contactBook.add(contact);
	}
	
	//method used to delete contacts from the contactBook
	public void deleteContact(String iD) {
		
		//validates that null is not deleted
		if(iD == null) {

			throw new IllegalArgumentException("Invalid Id");

		}
		
		// finds ID in the list can removes that contact
		for (int i = 0; i < contactBook.size() - 1; i++) {
			
			
			if (iD == contactBook.get(i).getID()) {
				contactBook.remove(contactBook.get(i));
			}
		}
	}
	
	//method used to edit Last Name
	public void editLastName(String lastName, String iD) {
		
		//validates new last name is not null
		if(lastName == null) {
			throw new IllegalArgumentException("Invalid LastName");
		}
		
		//validates new last new is correct length
		if(lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		//finds id and edits last name of that contact
		for (int i = 0; i < contactBook.size(); i++) {
			
			Contact newContact = contactBook.get(i);

			
			if (newContact.getID().equals(iD)) {
				newContact.setLastName(lastName);
			}
		}
	}
	
	//method used to edit First Name
	public void editFirstName(String firstName, String iD) {
		
		//validates new first name is not null
		if(firstName == null) {
			throw new IllegalArgumentException("Invalid FirstName");
		}
		
		//validates new first name is correct length
		if(firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		//finds id and edits first name of that contact
		for (int i = 0; i < contactBook.size(); i++) {
			
			Contact newContact = contactBook.get(i);
			
			if (newContact.getID().equals(iD)) {
				newContact.setFirstName(firstName);
			}
		}
	}
	
	//method used to edit address
	public void editAddress(String address, String iD) {
		
		//validates new address is not null
		if(address == null) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		//validates new address is correct length
		if(address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		//finds the id and edits the address to that contact
		for (int i = 0; i < contactBook.size(); i++) {
			
			Contact newContact = contactBook.get(i);
			
			if (newContact.getID().equals(iD)) {
				newContact.setAddress(address);
			}
		}
	}
	
	//method used to edit Phone Number
	public void editNumber(String phone, String iD) {
		
		//validates new number is not null
		if(phone == null) {
			throw new IllegalArgumentException("Invalid Number");
		}
		
		//validates new number is correct length
		if(phone.length() < 10 || phone.length() > 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		
		//finds id and edits number to that contact
		for (int i = 0; i < contactBook.size() ; i++) {
			
			Contact newContact = contactBook.get(i);
			
			if (newContact.getID().equals(iD)) {
				newContact.setPhone(phone);
			}
		}
	}
	
	public List<Contact> getList() {
		return contactBook;
	}
}
