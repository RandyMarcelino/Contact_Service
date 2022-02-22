package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.TaskService;

class TaskServiceTest {
	private String taskID, name, description, tooLongName, tooLongDescription;
	
	@BeforeEach
	void setUp() throws Exception {
	    taskID = "123ABC78DE";
	    name = "Default";
	    description = "Default";
	    tooLongName = "Default long name to test that long names do not work";
	    tooLongDescription = "Default long description to test that long descriptions do not work";
	}

	  @Test
	  void addTaskTest() {
	    TaskService service = new TaskService();
	    service.addTask();
	    assertAll("service",
	        () -> assertNotNull(service.getTaskList().get(0).getTaskID()),
	        () -> assertEquals("Default", service.getTaskList().get(0).getName()),
	        () -> assertEquals("Default", service.getTaskList().get(0).getDescription()));
	    service.addTask(name, description);
	    assertAll("service",
	        () -> assertNotNull(service.getTaskList().get(0).getTaskID()),
	        () -> assertEquals(name, service.getTaskList().get(0).getName()),
	        () -> assertEquals(description, service.getTaskList().get(0).getDescription()));
	  }

	  @Test
	  void deleteTaskTest() {
	    TaskService service = new TaskService();
	    service.addTask();
	    assertThrows(Exception.class, () -> service.deleteTask(taskID));
	    assertAll(() -> service.deleteTask(service.getTaskList().get(0).getTaskID()));
	  }

	  @Test
	  void updateNameTest() throws Exception {
	    TaskService service = new TaskService();
	    service.addTask();
	    service.updateName(service.getTaskList().get(0).getTaskID(), name);
	    assertEquals(name, service.getTaskList().get(0).getName());
	    assertThrows(IllegalArgumentException.class, () -> service.updateName(service.getTaskList().get(0).getTaskID(), tooLongName));
	    assertThrows(IllegalArgumentException.class, () -> service.updateName(service.getTaskList().get(0).getTaskID(), null));
	    assertThrows(Exception.class, () -> service.updateName(taskID, name));
	  }

	  @Test
	  void updateDescriptionTest() throws Exception {
	    TaskService service = new TaskService();
	    service.addTask();
	    service.updateDescription(service.getTaskList().get(0).getTaskID(), description);
	    assertEquals(description, service.getTaskList().get(0).getDescription());
	    assertThrows(IllegalArgumentException.class, () -> service.updateDescription(service.getTaskList().get(0).getTaskID(),tooLongDescription));
	    assertThrows(IllegalArgumentException.class, () -> service.updateDescription(service.getTaskList().get(0).getTaskID(), null));
	    assertThrows(Exception.class, () -> service.updateDescription(taskID, description));
	  }
}
