package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {
	  private String taskID, name, description, tooLongTaskID, tooLongName, tooLongDescription;
	
	@BeforeEach
	void setUp() throws Exception {
	    taskID = "123ABC78DE";
	    name = "Default";
	    description = "Default";
	    tooLongTaskID = "123ABC456DEF";
	    tooLongName = "Default long name to test that long names do not work";
	    tooLongDescription = "Default long description to test that long descriptions do not work";
	}
	
	@Test
	void emptyTaskTest() {
	  Task task = new Task();
	  assertAll("constructor",()-> assertNotNull(task.getTaskID()),
			  () -> assertNotNull(task.getName()),
	          () -> assertNotNull(task.getDescription()));
	}

	@Test
	void taskTest() {
	  Task task = new Task(taskID);
	  assertAll("constructor one",() -> assertEquals(taskID, task.getTaskID()),
			  () -> assertNotNull(task.getName()),
	          () -> assertNotNull(task.getDescription()));
	}

	@Test
	void completeTaskTest() {
	  Task task = new Task(taskID, name, description);
	  assertAll("constructor all", () -> assertEquals(taskID, task.getTaskID()),
			  () -> assertEquals(name, task.getName()),
	          () -> assertEquals(description, task.getDescription()));
	}
	
	@Test
	void setNameTest() {
	  Task task = new Task();
	  task.setName(name);
	  assertAll("name", () -> assertEquals(name, task.getName()),
			  () -> assertThrows(IllegalArgumentException.class, () -> task.setName(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> task.setName(tooLongName)));
	}
	
	@Test
	void setDescriptionTest() {
	  Task task = new Task();
	  task.setDescription(description);
	  assertAll("description", () -> assertEquals(description, task.getDescription()),
			  () -> assertThrows(IllegalArgumentException.class, () -> task.setDescription(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> task.setDescription(tooLongDescription)));
	}

	@Test
	void setTaskIDTest() {
	  Task task = new Task();
	  task.setTaskID(taskID);
	  assertAll("task ID", () -> assertEquals(taskID, task.getTaskID()),
			  () -> assertThrows(IllegalArgumentException.class, () -> task.setTaskID(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> task.setTaskID(tooLongTaskID)));
	}
}
