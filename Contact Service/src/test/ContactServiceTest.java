package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {
	private String contactID, firstName, lastName, phone, address, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

	@BeforeEach
	void setUp() {
		  contactID = "123ABC78DE";
		  firstName = "Randy";
		  lastName = "Marcelino";
		  phone = "1234567890";
		  address = "1234 Stone St Tampa FL 33512";
		  tooLongFirstName = "Jackie Chan";
		  tooLongLastName = "Popolymo Alhiemer";
		  tooLongPhoneNumber = "1234567890A";
		  tooShortPhoneNumber = "12345678B";
		  tooLongAddress = "123456789 Awesomest Lane Ever Jacksonville FL 33456";
	}

  @Test
  void addContactTest() {
    ContactService service = new ContactService();
    service.addContact();
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(0).getContactID()),
        () -> assertEquals("Randy", service.getContactList().get(0).getFirstName()),
        () -> assertEquals("Marcelino", service.getContactList().get(0).getLastName()),
        () -> assertEquals("1234567890", service.getContactList().get(0).getPhone()),
        () -> assertEquals("1234 Stone St Tampa FL 33512", service.getContactList().get(0).getAddress()));
    service.addContact(firstName, lastName, phone, address);
    assertAll("service",
        () -> assertNotNull(service.getContactList().get(0).getContactID()),
        () -> assertEquals(firstName, service.getContactList().get(0).getFirstName()),
        () -> assertEquals(lastName, service.getContactList().get(0).getLastName()),
        () -> assertEquals(phone, service.getContactList().get(0).getPhone()),
        () -> assertEquals(address, service.getContactList().get(0).getAddress()));
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.addContact();
    assertThrows(Exception.class, () -> service.deleteContact(contactID));
    assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactID()));
  }

  @Test
  void updatefirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.addContact();
    service.updateFirstName(service.getContactList().get(0).getContactID(), firstName);
    assertEquals(firstName, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactID(), tooLongFirstName));
    assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class, () -> service.updateFirstName(contactID, firstName));
  }

  @Test
  void updatelastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.addContact();
    service.updateLastName(service.getContactList().get(0).getContactID(), lastName);
    assertEquals(lastName, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactID(),tooLongLastName));
    assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class, () -> service.updateLastName(contactID, lastName));
  }

  @Test
  void updatephoneTest() throws Exception {
    ContactService service = new ContactService();
    service.addContact();
    service.updatePhone(service.getContactList().get(0).getContactID(), phone);
    assertEquals(phone, service.getContactList().get(0).getPhone());
    assertThrows(IllegalArgumentException.class, () -> service.updatePhone(service.getContactList().get(0).getContactID(), tooLongPhoneNumber));
    assertThrows(IllegalArgumentException.class, () -> service.updatePhone(service.getContactList().get(0).getContactID(), tooShortPhoneNumber));
    assertThrows(IllegalArgumentException.class,()-> service.updatePhone(service.getContactList().get(0).getContactID(), contactID));
    assertThrows(IllegalArgumentException.class,() -> service.updatePhone(service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class, () -> service.updatePhone(contactID, phone));
  }

  @Test
  void updateaddressTest() throws Exception {
    ContactService service = new ContactService();
    service.addContact();
    service.updateAddress(service.getContactList().get(0).getContactID(),address);
    assertEquals(address, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactID(), tooLongAddress));
    assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,() -> service.updateAddress(contactID, address));
  }
}
