//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package app;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;


public class AppointmentService {
		
	//list created to hold Appointments
	private static List<Appointment> apptList =  new ArrayList<Appointment>();
	private Date currentDate = new Date();
		
		public AppointmentService() {
			apptList = new ArrayList<Appointment>();
	}
 
		//Adds appointments too apptList
		public void addApp(Appointment appt) {
			
			
			//validates that ID is not already in use
			for (int i = 0; i <= apptList.size() -1; i++) {
				
				if (appt.getId().equals(apptList.get(i).getId())) {
					
					throw new IllegalArgumentException("Invalid ID in use");
					
				}
			}
			 
			apptList.add(appt);
		}
		
		//deletes appointments for apptList via ID
		public void deleteAppt(String iD) {
			
			apptList.removeIf(appt -> appt.getId() == iD); 
			
			//validates null was not passed through
			if(iD == null) {

				throw new IllegalArgumentException("Invalid null Id");

			}
				
		}
	
		//Edits date via ID
		//planning to play with this to learn more plus prompt says needs to be updateable for project one
		//this is something for me to think about
				public void editDate(Date date, String iD) {
				
					//checks that the ID and Name that were passed are not null
					if(date == null) {
						
						throw new IllegalArgumentException("Invalid Date");
						
					}
					
					if(iD == null) {
						
						throw new IllegalArgumentException("Invalid ID");
						
					}
					
					//validates name length is valid before updating
					if(date.before(currentDate)) {
						throw new IllegalArgumentException("Invalid Date");
					}
					
					//loops through list to compare IDs, If and Id is matched that objects date is updated
					for (int i = 0; i < apptList.size(); i++) {
						
						Appointment appt = apptList.get(i);
						
						if (appt.getId().equals(iD)) {
							
							appt.setDate(date);
							
						}
						
						//throws exception if ID is not found
						if((i == apptList.size()-1) && (apptList.get(i).getId() != iD)) {
							
							throw new IllegalArgumentException("No such ID");
							
						}
					}
				}
		
		//edits appointment's Description via id
		public void editDescription(String Description, String iD) {
			
			//checks if null was passed as the description or ID
			if(Description == null) {
				
				throw new IllegalArgumentException("Invalid Discription");
				
			}
			
			if(iD == null) {
				
				throw new IllegalArgumentException("Invalid ID");
				
			}
			
			//validates description length is valid before updating.
			if(Description.length() > 50) {
				
				throw new IllegalArgumentException("Invalid Discription Length");
				
			}
			
			//loops through apptlist to compare IDs, if one is matched the objects description is updated
			for (int i = 0; i < apptList.size(); i++) {
				
				Appointment appt = apptList.get(i);
				
				if (appt.getId().equals(iD)) {
					
					appt.setDescription(Description);
					
				}
				
				//throws exception if ID is not found
				if((i == apptList.size()-1) && (apptList.get(i).getId() != iD)) {
					
					throw new IllegalArgumentException("No such ID");
					
				}
			}
		}
		
		//allows us to access the list
		public List<Appointment> getList() {
			return apptList;
		}
}
