//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package app;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
		
	//list created to hold tasks 
	private static List<Task> taskList =  new ArrayList<Task>();
		
		public TaskService() {
			taskList = new ArrayList<Task>();
	}
 
		//Adds Tasks too taskList 
		public void addTask(Task task) {
			 
			
			//validates that ID is not already in use
			for (int i = 0; i <= taskList.size() -1; i++) {
				
				if (task.getId().equals(taskList.get(i).getId())) {
					
					throw new IllegalArgumentException("Invalid ID");
					
				}
			}
			 
			taskList.add(task);
		}
		
		//deletes task for taskList via ID
		public void deleteTask(String iD) {
			
			
			
			//validates null was not passed through
			if(iD == null) {

				throw new IllegalArgumentException("Invalid Id");

			}
			
			taskList.removeIf(task -> task.getId() == iD);
			
		}
	
		//Edits name via ID
		public void editName(String Name, String iD) {
		
			//checks that the ID and Name that were passed are not null
			if(Name == null) {
				
				throw new IllegalArgumentException("Invalid Name");
				
			}
			
			//checks that id passed is not null
			if(iD == null) {
				
				throw new IllegalArgumentException("Invalid ID");
				
			}
			
			//validates name length is valid before updating
			if(Name.length() > 20) {
				throw new IllegalArgumentException("Invalid Name Length");
			}
			
			//loops through list to compare IDs, If and Id is matched that objects name is updated
			for (int i = 0; i < taskList.size(); i++) {
				
				Task task = taskList.get(i);
				
				if (task.getId().equals(iD)) {
					
					task.setName(Name);
					
				}
				
				//throws exception if ID is not found
				if((i == taskList.size()-1) && (taskList.get(i).getId() != iD)) {
					
					throw new IllegalArgumentException("No such ID");
					
				}
			}
		}
		
		//edits Task's Description via id
		public void editDescription(String Description, String iD) {
			
			//checks if null was passed as the description or ID
			if(Description == null) {
				
				throw new IllegalArgumentException("Invalid Discription");
				
			}
			
			//validates iD is not null
			if(iD == null) {
				
				throw new IllegalArgumentException("Invalid ID");
				
			}
			
			//validates description length is valid before updating.
			if(Description.length() > 50) {
				
				throw new IllegalArgumentException("Invalid Discription Length");
				
			}
			
			//loops through list to compare IDs, if one is matched the objects description is updated
			for (int i = 0; i < taskList.size(); i++) {
				
				Task task = taskList.get(i);
				
				if (task.getId().equals(iD)) {
					
					task.setDescription(Description);
					
				}
				
				//throws exception if ID is not found
				if((i == taskList.size()-1) && (taskList.get(i).getId() != iD)) {
					
					throw new IllegalArgumentException("No such ID");
					
				}
			}
		}
		
		
		//allows us to access the list
		public List<Task> getList() {
			return taskList;
		}
}