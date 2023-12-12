//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package app;

import java.util.Date;


public class Appointment {
	private String ID = "0";
	private Date date;
	private String Description = "a"; 
	
	//holds current date to compare so new dates don't go in the past
	Date currentDate = new Date();
	
	//creates Appointments
	public Appointment(Date appDate, String newDescription, String iD) {
		
		//validates date in valid
		if(appDate==null || appDate.before(currentDate)) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		//validates description is valid
		if ((newDescription == null) || (newDescription.length() > 50)) {
			throw new IllegalArgumentException("Invalid Discription Length");
		}
		
		//validates id is valid
		if ((iD == null) || (iD.length() > 10)) {
			throw new IllegalArgumentException("Invalid ID Length");
		}  
		 
		ID = iD;
		setDate(appDate);
		setDescription(newDescription);
	}
	
	//returns date 
	public Date getDate() {
		return date;
	}
	
	//allows you to update date...for later use
	public void setDate(Date newDate) {
		
		this.date = newDate;
	}
	
	//returns description for validation
	public String getDescription() {
		return Description;
	}
	
	//allows you to update description
	public void setDescription(String newDescription) {
		
		this.Description = newDescription;
	}
	
	//returns id
	public String getId() {
		return ID;
	}
	
}
