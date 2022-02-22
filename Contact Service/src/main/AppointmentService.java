package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	 //Initialize the list of contacts.  
	  private List<Appointment> appointmentList = new ArrayList<>();
	
	  //Get a new unique ID.
	  private String newUniqueID() {
		  //Utilizes the UUID random method to get random id turn it to string then get the first 10.
		  return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	  }
	
	  //Method for searching for a contact by their id.
	  private Appointment searchForAppointment(String id) throws Exception {
		int i = 0;
		while (i < appointmentList.size()) {
		  if (id.equals(appointmentList.get(i).getAppointmentID())) {
		    return appointmentList.get(i);
		  }
		  i++;
		}
		throw new Exception("The ID does not exist.");
	  }
	
	  //Create a new contact with no information.
	  public void addAppointment() {
	    Appointment appointment = new Appointment(newUniqueID());
	    appointmentList.add(appointment);
	  }
	
	  //Create a new contacts with all required information
	  public void addAppointment(Date appointmentDate, String description) {
	    Appointment appointment = new Appointment(newUniqueID(), appointmentDate, description);
	    appointmentList.add(appointment);
	  }
	  //Delete an existing appointment from the list.
	  public void deleteAppointment(String id) throws Exception {
	    appointmentList.remove(searchForAppointment(id));
	  }
	  
	  //Method to return the full list of current contacts.
	  public List<Appointment> getAppointmentList() {
		  return appointmentList;
	  }
}
