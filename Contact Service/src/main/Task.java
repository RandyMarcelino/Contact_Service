package main;

public class Task {
  private static final int NAME_LENGTH = 20;
  private static final int ID_LENGTH = 10;
  private static final int DESCRIPTION_LENGTH = 50;
  private String taskID;
  private String name;
  private String description;

  public Task() {
    taskID = "Default";
    name = "Default";
    description = "Default";
  }

  public Task(String taskID) {
    setTaskID(taskID);
    name = "Default";
    description = "Default";
  }

  public Task(String taskID, String name, String description) {
    setTaskID(taskID);
    setName(name);
    setDescription(description);
  }

  public String getTaskID() {
	  return this.taskID;
  }

  public String getName() {
	  return this.name;
  }
  
  public String getDescription() {
	  return this.description;
  }

  public void setName(String name) {
    if (name == null || name.length() > NAME_LENGTH) {
      throw new IllegalArgumentException("Name cannot be longer than " + NAME_LENGTH + " characters or null");
    } else {
      this.name = name;
    }
  }

  public void setDescription(String Description) {
    if (Description == null || Description.length() > DESCRIPTION_LENGTH) {
      throw new IllegalArgumentException("Description cannot be longer than " + DESCRIPTION_LENGTH + " characters or null");
    } else {
      this.description = Description;
    }
  }

  public void setTaskID(String taskId) {
    if (taskId == null || taskId.length() > ID_LENGTH) {
      throw new IllegalArgumentException("ID cannot be longer than " + ID_LENGTH + " characters or null");
    } else {
      this.taskID = taskId;
    }
  }
}
