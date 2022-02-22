package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

	//Initialize the list of contacts.  
	private List<Contact> contactList = new ArrayList<>();

	//Create a new contact with no information.
	public void addContact() {
	  Contact contact = new Contact(newUniqueID());
	  contactList.add(contact);
	}
	  
	//Create a new contacts with all required information
	public void addContact(String firstname, String lastname, String phonenumber, String address) {
		Contact contact = new Contact(newUniqueID(), firstname, lastname, phonenumber, address);contactList.add(contact);
	}

	//Delete an existing contact from the list.
	public void deleteContact(String id) throws Exception {
	  contactList.remove(searchForContact(id));
	}

	//Update an existing contacts first name.
	public void updateFirstName(String id, String firstName) throws Exception {
	  searchForContact(id).setFirstName(firstName);
	}

	//Update an existing contacts last name.
	public void updateLastName(String id, String lastName) throws Exception {
	  searchForContact(id).setLastName(lastName);
	}

	//Update an existing contacts phone number.
	public void updatePhone(String id, String phone) throws Exception {
	  searchForContact(id).setPhone(phone);
	}

	//Update an existing contacts address.
	public void updateAddress(String id, String address) throws Exception {
	  searchForContact(id).setAddress(address);
	}

	//Method to return the full list of current contacts.
	public List<Contact> getContactList() { 
		return contactList;   
	}

	//Get a new unique ID.
	private String newUniqueID() {
		//Utilizes the UUID random method to get random id turn it to string then get the first 10.
	    return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	  }

	//Method for searching for a contact by their id.
	private Contact searchForContact(String id) throws Exception {
	  int i = 0;
	  while (i < contactList.size()) {
	    if (id.equals(contactList.get(i).getContactID())) {
	      return contactList.get(i);
	    }
	    i++;
	  }
	  throw new Exception("The ID does not exist.");
	}
}
