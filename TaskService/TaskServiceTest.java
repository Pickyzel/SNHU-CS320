package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.Task;
import app.TaskService;

public class TaskServiceTest {
	
	TaskService service = new TaskService();
	
	@Test
	void TestAddTaskAddsATaskToList() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		assertTrue(service.getList().get(0).getName() == "MyTask");
		assertTrue(service.getList().get(0).getDescription() == "MyDescription");
		assertTrue(service.getList().get(0).getId() == "12345");
		
	}
	
	@Test
	void TestDeleteTaskViaID() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		service.deleteTask("12345");
		assertTrue(service.getList().size() == 0);
	}
	
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
	@Test
	void TestEditName() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		service.editName("MyNewTaskName", "12345");
		
		assertTrue(service.getList().get(0).getName() == "MyNewTaskName");
	}
	
	@Test
	void TestEditDescription() {
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);
		
		service.editDescription("ThisIsMyNewDescription", "12345");
		
		assertTrue(service.getList().get(0).getDescription() == "ThisIsMyNewDescription");
	}
	
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
	
	@Test
	void TestCantDeleteWithNullID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask(null);
		});
	}
	
	@Test
	void TestCantEditNameWithNullID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName("NewTask",null);
		});
	}
	
	@Test
	void TestCantEditNameWithNullName() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName(null,"12345");
		});
	}
	
	@Test
	void TestCantEditNameWith20Char() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName("12345678901234567890123","12345");
		});
	}
	
	@Test
	void TestCantEditNameWithIDNotFound() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editName("mynewTask","1765");
		});
	}
		
	@Test
	void TestCantEditDiscriptionWithNullName() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription(null,"12345");
		});
	}
	
	@Test
	void TestCantEditDiscriptionWithNullID() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription("NewTask",null);
		});
	} 
	
	@Test
	void TestCantEditDiscriptionMoreThan50() {
		
		TaskService service = new TaskService();
		
		Task task = new Task("MyTask", "MyDescription", "12345");
		service.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.editDescription("12345678901234567890123456789012345678901234567890123","12345");
		});
	}
	
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
