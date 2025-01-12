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
		
		if(contact.getID() == null) {

			throw new IllegalArgumentException("Invalid Id");

		}
		
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
		
		if(iD == null) {

			throw new IllegalArgumentException("Invalid Id");

		}
		
		for (int i = 0; i < contactBook.size() - 1; i++) {
			
			
			if (iD == contactBook.get(i).getID()) {
				contactBook.remove(contactBook.get(i));
			}
			else {
				throw new IllegalArgumentException("No such ID");
			}
		}
	}
	
	//method used to edit Last Name
	public void editLastName(String lastName, String iD) {
		
		if(lastName == null) {
			throw new IllegalArgumentException("Invalid LastName");
		}
		if(lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		for (int i = 0; i < contactBook.size(); i++) {
			
			Contact newContact = contactBook.get(i);

			
			if (newContact.getID().equals(iD)) {
				newContact.setLastName(lastName);
			}
		}
	}
	
	//method used to edit First Name
	public void editFirstName(String firstName, String iD) {
		
		if(firstName == null) {
			throw new IllegalArgumentException("Invalid FirstName");
		}
		
		if(firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		for (int i = 0; i < contactBook.size(); i++) {
			
			Contact newContact = contactBook.get(i);
			
			
			
			if (newContact.getID().equals(iD)) {
				newContact.setFirstName(firstName);
			}
		}
	}
	
	//method used to edit address
	public void editAddress(String address, String iD) {
		
		if(address == null) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		if(address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		for (int i = 0; i < contactBook.size(); i++) {
			
			Contact newContact = contactBook.get(i);
			
			if (newContact.getID().equals(iD)) {
				newContact.setAddress(address);
			}
		}
	}
	
	//method used to edit Phone Number
	public void editNumber(String phone, String iD) {
		
		if(phone == null) {
			throw new IllegalArgumentException("Invalid Number");
		}
		
		if(phone.length() < 10 || phone.length() > 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		
		for (int i = 0; i < contactBook.size() -1 ; i++) {
			
		}
	}
	
	public List<Contact> getList() {
		return contactBook;
	}
}
