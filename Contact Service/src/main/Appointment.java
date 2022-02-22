package main;

import java.util.Calendar;
import java.util.Date;

public class Appointment {
	private static final int ID_LENGTH = 10;
	private static final int DESCRIPTION_LENGTH = 50;
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	public Appointment() {
	    appointmentID = "Default";
	    appointmentDate = new Date(3000, Calendar.FEBRUARY, 13);
	    description = "Default";
	}

	public Appointment(String appointmentID) {
	    setAppointmentID(appointmentID);
	    appointmentDate = new Date(3000, Calendar.FEBRUARY, 13);
	    description = "Default";
	}

	public Appointment(String appointmentID, Date appointmentDate, String description) {
	    setAppointmentID(appointmentID);
	    setAppointmentDate(appointmentDate);
	    setDescription(description);
	}
	
	public String getAppointmentID() {
		  return this.appointmentID;
	}
	
	public Date getAppointmentDate() {
		  return this.appointmentDate;
	}
	  
	public String getDescription() {
		  return this.description;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
	    if (appointmentDate == null || appointmentDate.before(new Date())) {
	      throw new IllegalArgumentException("Date cannot be in the past or null");
	    } else {
	      this.appointmentDate = appointmentDate;
	    }
	}
	
	public void setDescription(String Description) {
	    if (Description == null || Description.length() > DESCRIPTION_LENGTH) {
	      throw new IllegalArgumentException("Description cannot be longer than " + DESCRIPTION_LENGTH + " characters or null");
	    } else {
	      this.description = Description;
	    }
	}
	
	public void setAppointmentID(String appointmentId) {
	    if (appointmentId == null || appointmentId.length() > ID_LENGTH) {
	      throw new IllegalArgumentException("ID cannot be longer than " + ID_LENGTH + " characters or null");
			    } else {
			      this.appointmentID = appointmentId;
			    }
	}
}
