package app;

public class Task {
	
	private String ID = "0";
	private String Name = "a";
	private String Description = "a";
	
	public Task(String newName, String newDescription, String iD) {
		
		
		
		if((newName == null) || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name Length");
		}
		
		if ((newDescription == null) || (newDescription.length() > 50)) {
			throw new IllegalArgumentException("Invalid Discription Length");
		}
		
		if ((iD == null) || (iD.length() > 10)) {
			throw new IllegalArgumentException("Invalid ID Length");
		}  
		 
		ID = iD;
		Name = newName;
		Description = newDescription;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String newName) {
		
		if((newName == null) || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name Length");
		}
		
		this.Name = newName;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String newDescription) {
		
		if((newDescription == null) || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Name Length");
		}
		
		this.Description = newDescription;
	}
	
	public String getId() {
		return ID;
	}
}
