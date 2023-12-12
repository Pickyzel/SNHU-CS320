//Tiffany McDonnell
//12-1-23
//SNHU CS-320

package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.Task;
import app.TaskService;

public class TaskServiceTest {
	
	TaskService service = new TaskService();
	
	//tests add task
	@Test
	void TestAddTaskAddsATaskToList() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		assertTrue(service.getList().get(0).getName() == "MyTask");
		assertTrue(service.getList().get(0).getDescription() == "MyDescription");
		assertTrue(service.getList().get(0).getId() == "12345");
		
	}
	 
	//tests task can be deleted via id
	@Test
	void TestDeleteTaskViaID() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		service.deleteTask("12345");
		assertTrue(service.getList().size() == 0);
	}
	
	//tests task can be found within a list and deleted
	@Test
	void TestDeleteTaskViaIDWithLargerList() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		Task task2 = new Task("MyTask", "MyDescription", "11111");
		service.addTask(task2);
		
		Task task3 = new Task("MyTask", "MyDescription", "12222");
		service.addTask(task3);
		
		assertTrue(service.getList().size() == 3);
		
		service.deleteTask("11111");
		assertTrue(service.getList().size() == 2);
		
		assertFalse(service.getList().contains(task2));	 
		
	}
	
	//tests edit name
	@Test
	void TestEditName() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		service.editName("MyNewTaskName", "12345");
		
		assertTrue(service.getList().get(0).getName() == "MyNewTaskName");
	}
	
	//tests edit description
	@Test
	void TestEditDescription() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		service.editDescription("ThisIsMyNewDescription", "12345");
		
		assertTrue(service.getList().get(0).getDescription() == "ThisIsMyNewDescription");
	}
	
	//tests unique ids
	@Test 
	void TestCantAddWithDuplicateID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Task newTask = new Task("NewTask","NewDescription","12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(newTask);
		});
	}
	
	//tests null id can not be deleted
	@Test
	void TestCantDeleteWithNullID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask(null);
		});
	}
	
	//tests name edit can not have null id passed
	@Test
	void TestCantEditNameWithNullID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName("NewTask",null);
		});
	}
	
	//tests name edit can not of null name passed
	@Test
	void TestCantEditNameWithNullName() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName(null,"12345");
		});
	}
	
	//tests edit name can't be more than 20 char
	@Test
	void TestCantEditNameWith20Char() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName("12345678901234567890123","12345");
		});
	}
	
	//tests exception is thrown if no id excists
	@Test
	void TestCantEditNameWithIDNotFound() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName("mynewTask","1765");
		});
	}
		
	//test can not edit description with null name
	@Test
	void TestCantEditDescriptionWithNullName() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription(null,"12345");
		});
	}
	
	//tests can not edit description with null id
	@Test
	void TestCantEditDescriptionWithNullID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription("NewTask",null);
		});
	} 
	
	//tests can not description with more than 50 char
	@Test
	void TestCantEditDescriptionMoreThan50() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription("12345678901234567890123456789012345678901234567890123","12345");
		});
	}
	
	//tests that can not edit description if id does not exist
	@Test
	void TestCantEditDescriptionWithIDNotFound() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription("mynewTask","1765");
		});
	}
	
}
