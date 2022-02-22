package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	private String contactId, firstName, lastName, phone, address, tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

	@BeforeEach
	void setUp() {
	  contactId = "123ABC78DE";
	  firstName = "Randy";
	  lastName = "Marcelino";
	  phone = "1234567890";
	  address = "1234 Stone St Tampa FL 33512";
	  tooLongContactId = "123ABC456DEF";
	  tooLongFirstName = "Jackie Chan";
	  tooLongLastName = "Popolymo Alhiemer";
	  tooLongPhoneNumber = "1234567890A";
	  tooShortPhoneNumber = "12345678B";
	  tooLongAddress = "123456789 Awesomest Lane Ever Jacksonville FL 33456";
	}
	
	@Test
	void emptyContactTest() {
	  Contact contact = new Contact();
	  assertAll("constructor",()-> assertNotNull(contact.getContactID()),
			  () -> assertNotNull(contact.getFirstName()),
	          () -> assertNotNull(contact.getLastName()),
	          () -> assertNotNull(contact.getPhone()),
	          () -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void contactTest() {
	  Contact contact = new Contact(contactId);
	  assertAll("constructor one",() -> assertEquals(contactId, contact.getContactID()),
			  () -> assertNotNull(contact.getFirstName()),
	          () -> assertNotNull(contact.getLastName()),
	          () -> assertNotNull(contact.getPhone()),
	          () -> assertNotNull(contact.getAddress()));
	}
	
	@Test
	void completeContactTest() {
	  Contact contact = new Contact(contactId, firstName, lastName, phone, address);
	  assertAll("constructor all", () -> assertEquals(contactId, contact.getContactID()),
			  () -> assertEquals(firstName, contact.getFirstName()),
	          () -> assertEquals(lastName, contact.getLastName()),
	          () -> assertEquals(phone, contact.getPhone()),
	          () -> assertEquals(address, contact.getAddress()));
	}
	
	@Test
	void setFirstNameTest() {
	  Contact contact = new Contact();
	  contact.setFirstName(firstName);
	  assertAll("first name", () -> assertEquals(firstName, contact.getFirstName()),
			  () -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(tooLongFirstName)));
	}
	
	@Test
	void setLastNameTest() {
	  Contact contact = new Contact();
	  contact.setLastName(lastName);
	  assertAll("last name",() -> assertEquals(lastName, contact.getLastName()),
			  () -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null)),
			  () -> assertThrows(IllegalArgumentException.class, () -> contact.setLastName(tooLongLastName)));
	}
	
	@Test
	void setPhoneTest() {
	  Contact contact = new Contact();
	  contact.setPhone(phone);
	  assertAll("phone number", ()-> assertEquals(phone, contact.getPhone()),
			  () -> assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null)),
	          () -> assertThrows(IllegalArgumentException.class, () -> contact.setPhone(tooLongPhoneNumber)),
	          () -> assertThrows(IllegalArgumentException.class, () -> contact.setPhone(tooShortPhoneNumber)),
	          () -> assertThrows(IllegalArgumentException.class, () -> contact.setPhone(contactId)));
	}
	
	@Test
	void setAddressTest() {
	  Contact contact = new Contact();
	  contact.setAddress(address);
	  assertAll("address ",() -> assertEquals(address, contact.getAddress()),
			  () -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null)),
	          () -> assertThrows(IllegalArgumentException.class, () -> contact.setAddress(tooLongAddress)));
	}
	
	@Test
	void setContactIDTest() {
	  Contact contact = new Contact();
	  contact.setContactID(contactId);
	  assertAll(
	      "contact ID", () -> assertEquals(contactId, contact.getContactID()),
	      () -> assertThrows(IllegalArgumentException.class, () -> contact.setContactID(null)),
	      () -> assertThrows(IllegalArgumentException.class, () -> contact.setContactID(tooLongContactId)));
	}
}
