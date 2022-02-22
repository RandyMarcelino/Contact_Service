package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

class AppointmentServiceTest {
	  private String appointmentID, description;
	  private Date appointmentDate;
	  
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		appointmentID = "123ABC78DE";
	    appointmentDate = new Date(3000, Calendar.FEBRUARY, 13);
	    description = "Default";
	}
	  @SuppressWarnings("deprecation")
	@Test
	  void addAppointmentTest() {
	    AppointmentService service = new AppointmentService();
	    service.addAppointment();
	    assertAll("service",
	        () -> assertNotNull(service.getAppointmentList().get(0).getAppointmentID()),
	        () -> assertEquals(new Date(3000, Calendar.FEBRUARY, 13), service.getAppointmentList().get(0).getAppointmentDate()),
	        () -> assertEquals("Default", service.getAppointmentList().get(0).getDescription()));
	    service.addAppointment(appointmentDate, description);
	    assertAll("service",
	        () -> assertNotNull(service.getAppointmentList().get(0).getAppointmentID()),
	        () -> assertEquals(appointmentDate, service.getAppointmentList().get(0).getAppointmentDate()),
	        () -> assertEquals(description, service.getAppointmentList().get(0).getDescription()));
	  }

	  @Test
	  void deleteAppointmentTest() {
	    AppointmentService service = new AppointmentService();
	    service.addAppointment();
	    assertThrows(Exception.class, () -> service.deleteAppointment(appointmentID));
	    assertAll(() -> service.deleteAppointment(service.getAppointmentList().get(0).getAppointmentID()));
	  }
}
