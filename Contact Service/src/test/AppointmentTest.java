package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Appointment;

class AppointmentTest {
	  private String appointmentID, description, tooLongAppointmentID, tooLongDescription;
	  private Date appointmentDate, pastAppointmentDate;
	  
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		appointmentID = "123ABC78DE";
	    appointmentDate = new Date(3000, Calendar.FEBRUARY, 13);
	    description = "Default";
	    tooLongAppointmentID = "123ABC456DEF";
	    pastAppointmentDate = new Date(0);
	    tooLongDescription = "Default long description to test that long descriptions do not work";
	}
	
	@Test
	void emptyAppointmentTest() {
	  Appointment appointment = new Appointment();
	  assertAll("constructor",()-> assertNotNull(appointment.getAppointmentID()),
			  () -> assertNotNull(appointment.getAppointmentDate()),
	          () -> assertNotNull(appointment.getDescription()));
	}

	@Test
	void appointmentTest() {
	  Appointment appointment = new Appointment(appointmentID);
	  assertAll("constructor one",() -> assertEquals(appointmentID, appointment.getAppointmentID()),
			  () -> assertNotNull(appointment.getAppointmentDate()),
	          () -> assertNotNull(appointment.getDescription()));
	}

	@Test
	void completeAppointmentTest() {
	  Appointment appointment = new Appointment(appointmentID, appointmentDate, description);
	  assertAll("constructor all", () -> assertEquals(appointmentID, appointment.getAppointmentID()),
			  () -> assertEquals(appointmentDate, appointment.getAppointmentDate()),
	          () -> assertEquals(description, appointment.getDescription()));
	}
	
	@Test
	void setAppointmentDateTest() {
	  Appointment appointment = new Appointment();
	  appointment.setAppointmentDate(appointmentDate);
	  assertAll("appointmentDate", () -> assertEquals(appointmentDate, appointment.getAppointmentDate()),
			  () -> assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastAppointmentDate)));
	}
	
	@Test
	void setDescriptionTest() {
	  Appointment appointment = new Appointment();
	  appointment.setDescription(description);
	  assertAll("description", () -> assertEquals(description, appointment.getDescription()),
			  () -> assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(tooLongDescription)));
	}

	@Test
	void setAppointmentIDTest() {
	  Appointment appointment = new Appointment();
	  appointment.setAppointmentID(appointmentID);
	  assertAll("appointment ID", () -> assertEquals(appointmentID, appointment.getAppointmentID()),
			  () -> assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentID(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentID(tooLongAppointmentID)));
	}
}
