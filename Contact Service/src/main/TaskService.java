package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
  //Initialize the list of contacts.  
  private List<Task> taskList = new ArrayList<>();

  //Get a new unique ID.
  private String newUniqueID() {
	  //Utilizes the UUID random method to get random id turn it to string then get the first 10.
	  return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
  }

  //Method for searching for a contact by their id.
  private Task searchForTask(String id) throws Exception {
	int i = 0;
	while (i < taskList.size()) {
	  if (id.equals(taskList.get(i).getTaskID())) {
	    return taskList.get(i);
	  }
	  i++;
	}
	throw new Exception("The ID does not exist.");
  }

  //Create a new contact with no information.
  public void addTask() {
    Task task = new Task(newUniqueID());
    taskList.add(task);
  }

  //Create a new contacts with all required information
  public void addTask(String name, String description) {
    Task task = new Task(newUniqueID(), name, description);
    taskList.add(task);
  }
  //Delete an existing task from the list.
  public void deleteTask(String id) throws Exception {
    taskList.remove(searchForTask(id));
  }
  //Update an existing task name.
  public void updateName(String id, String name) throws Exception {
    searchForTask(id).setName(name);
  }

  //Update an existing task description.
  public void updateDescription(String id, String description) throws Exception {
    searchForTask(id).setDescription(description);
  }
  //Method to return the full list of current contacts.
  public List<Task> getTaskList() {
	  return taskList;
  }
}
