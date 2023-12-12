//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.Task;

public class TaskTest {
 
	//Tests that a task can be created with assigned values
	@Test
	void testTask() {
		
		Task task = new Task("MyTaskName", "MyDescription","12345");
		
		assertTrue(task.getName().equals("MyTaskName"));
		assertTrue(task.getDescription().equals("MyDescription"));
		assertTrue(task.getId().equals("12345"));
	 
		
	}
	 
	//Tests that a task name can be created with exactly 20 characters for the name(no exception thrown)
	@Test
	void testTaskNameIsEqualLength() {
		Task task = new Task("MyTaskisNowTwenty20.","MyDescription","12345");
		assertTrue(task.getName().length() == 20);
	}
	
	//Tests exception is thrown when name is more than 20 characters
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("ThisIstooLongForTheTaskName","MyDescription","12345");
			});
	}
	
	//Tests that task is created with less than 20 character name(no exception thrown)
	@Test
	void testTaskNameLessThan10() {
		Task task = new Task("MyTaskName","MyDescription","12345");
		assertTrue(task.getName().length() < 20);
	}
	
	//Tests task is created and name is not null after creation
	@Test
	void testTaskNameNotNull() {
		Task task = new Task("MyTaskName","MyDescription","12345");
		assertNotNull(task.getName());
	}
	
	//Tests that exception is thrown if task name is null
	@Test
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null,"MyDescription","12345");
		});
	}
	
	//Tests task Name can be changed
	@Test
	void testChangeName() {
		Task task = new Task("MyTaskName","MyDescription","12345");
		assertTrue(task.getName() == "MyTaskName");
		task.setName("NewTask");
		assertTrue(task.getName() == "NewTask");
	}
	
	//Tests Name cannot be changed to null
	@Test
	void testTaskNameChangedToNull() {
		Task task = new Task("MyTaskName","MyDescription","12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	//Tests Name cannot be changed to more than 20
	@Test
	void testChangeNameGreaterthan20() {
		Task task = new Task("MyTaskName","MyDescription","12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName("MyTaskNameIsNowgoingToBeGreaterThan20");
		});
	}
	
	//Tests that a task ID can be created with exactly 10 characters for the name(no exception thrown)
		@Test
		void testTaskIdIsEqualLength() {
			Task task = new Task("MyTask","MyDescription","1234567890");
			assertTrue(task.getId().length() == 10);
		}
		
		//Tests exception is thrown when Id is more than 10 characters
		@Test
		void testTaskIDIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("MyTask","MyDescription","1234567890123");
				});
		}
		
		//Tests that task Id is created with less than 10 character(no exception thrown)
		@Test
		void testTaskIDLessThan10() {
			Task task = new Task("MyTaskName","MyDescription","12345");
			assertTrue(task.getId().length() < 10);
		}
		
		//Tests task is created and Id is not null after creation
		@Test
		void testTaskIdNotNull() {
			Task task = new Task("MyTaskName","MyDescription","12345");
			assertNotNull(task.getId());
		}
		
		//Tests that exception is thrown if task Id is null
		@Test
		void testTaskIdIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("MyTaskName","MyDescription",null);
			});
		}
		
		//Tests that a task description can be created with exactly 50 characters for the name(no exception thrown)
		@Test
		void testTaskDescriptionIsEqualLength() {
			Task task = new Task("MyTask","MyDescriptionIsGoingToHaveToBe50InLengthSoHahahaha","12345");
			assertTrue(task.getDescription().length() == 50);
		}
		
		//Tests exception is thrown when Description is more than 50 characters
		@Test
		void testTaskDescriptionIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("MyTask","MyDescriptionForThisTaskWillHaveMoreThan50Characters","12345");
				});
		}
		
		//Tests that task description is created with less than 50 character name(no exception thrown)
		@Test
		void testTaskDescriptionLessThan50() {
			Task task = new Task("MyTaskName","MyDescription","12345");
			assertTrue(task.getDescription().length() < 50);
		}
		
		//Tests task is created and Description is not null after creation
		@Test
		void testTaskDescriptionNotNull() {
			Task task = new Task("MyTaskName","MyDescription","12345");
			assertNotNull(task.getDescription());
		}
		
		//Tests that exception is thrown if task Description is null
		@Test
		void testTaskDescriptionIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task("MyTaskName",null,"12345");
			});
		}
		
		//Tests task Description can be changed
		@Test
		void testChangeDescription() {
			Task task = new Task("MyTaskName","MyDescription","12345");
			assertTrue(task.getDescription() == "MyDescription");
			task.setDescription("NewDescription");
			assertTrue(task.getDescription() == "NewDescription");
		}
		
		//Tests Description cannot be changed to null
		@Test
		void testTaskDescriptionChangedToNull() {
			Task task = new Task("MyTaskName","MyDescription","12345");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				task.setDescription(null);
			});
		}
		
		//Tests Description cannot be changed to more than 50
		@Test
		void testChangeDescriptionGreaterthan50() {
			Task task = new Task("MyTaskName","MyDiscription","12345");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				task.setDescription("MyTaskDescriptionIsNowgoingToBeGreaterThan50ButThisCouldTakeAwhile");
			});
		}
	
}
