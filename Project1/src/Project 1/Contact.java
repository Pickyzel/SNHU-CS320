//Tiffany McDonnell
//11-09-23
//SNHU CS - 320

package app;

public class Contact {

	private String ID = "0";
	private String firstName = "a";
	private String lastName = "a";
	private String phone = "0000000000";
	private String address = "a";
	
	//creates contacts
	public Contact(String newFirstName, String newLastName, String number, String newAddress, String newID) {
		
		if((newID == null) || newID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID Length");
		}
		
		if ((newFirstName == null) || (newFirstName.length() > 10)) {
			throw new IllegalArgumentException("Invalid First Name Length");
		}
		
		if ((newLastName == null) || (newLastName.length() > 10)) {
			throw new IllegalArgumentException("Invalid Last Name Length");
		}
		
		if ((number == null) || (number.length() != 10)) {
			throw new IllegalArgumentException("Invalid Contact Phone Number Format");
		}
		
		if ((newAddress == null) || (newAddress.length() > 30)) {
			throw new IllegalArgumentException("Invalid Address");
		}
		 
		ID = newID;
		firstName = newFirstName;
		lastName = newLastName;
		phone = number;
		address = newAddress;
	}
	
	//returns id
	public String getID() {
		
		return ID;
	}
	

	//returns First Name
	public String getFirstName() {
		return firstName;
	}
	
	//Sets FirstName
	public void setFirstName(String name) {
		
		if ((firstName == null) || (name == null) || (firstName.length() > 10)) {
			throw new IllegalArgumentException("Invalid First Name Length");
		}
		
		firstName = name;
	}
	
	//Sets Last Name
	public void setLastName(String name) {
		
		if ((lastName == null) || (name == null) || (lastName.length() > 10)) {
			throw new IllegalArgumentException("Invalid Last Name Length");
		}
		
		lastName = name;
	}
	
	//Returns Last Name
	public String getLastName() {
		return lastName;
	}
	
	//Sets Phone Number
	public void setPhone(String number) {
		
		if ((this.phone == null) || (number == null) || (this.phone.length() != 10)) {
			throw new IllegalArgumentException("Invalid Contact Phone Number Format");
		}
		
		phone = number;
	} 
	
	//Returns Phone Number
	public String getPhone() {
		return phone;
	}
	
	//Sets Address
	public void setAddress(String newAddress) {
		
		if ((address == null) || (newAddress == null) || (address.length() > 30)) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		address = newAddress;
	}
	
	//Returns Address
	public String getAddress() {
		return address;
	}
}
