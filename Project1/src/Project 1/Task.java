//Tiffany McDonnell
//12-1-23
//SNHU CS-320
package app;

public class Task {
	
	private String ID = "0";
	private String Name = "a";
	private String Description = "a";
	
	//creates a task
	public Task(String newName, String newDescription, String iD) {
		
		
		//validates that name legal
		if((newName == null) || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name Length");
		}
		
		//validates description is legal
		if ((newDescription == null) || (newDescription.length() > 50)) {
			throw new IllegalArgumentException("Invalid Discription Length");
		}
		
		//validates id is legal
		if ((iD == null) || (iD.length() > 10)) {
			throw new IllegalArgumentException("Invalid ID Length");
		}  
		 
		ID = iD;
		Name = newName;
		Description = newDescription;
	}
	
	//returns Name
	public String getName() {
		return Name;
	}
	
	//Sets Name
	public void setName(String newName) {
		
		//validates name is legal
		if((newName == null) || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name Length");
		}
		
		this.Name = newName;
	}
	
	//Returns Description
	public String getDescription() {
		return Description;
	}
	
	//Sets Description
	public void setDescription(String newDescription) {
		
		//validates description
		if((newDescription == null) || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Name Length");
		}
		
		this.Description = newDescription;
	}
	
	//Returns ID
	public String getId() {
		return ID;
	}
}
