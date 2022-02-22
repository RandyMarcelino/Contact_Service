package main;

public class Contact {
	private static final int PHONE_LENGTH = 10;
	private static final int ID_LENGTH = 10;
	private static final int FIRST_NAME_LENGTH = 10;
	private static final int LAST_NAME_LENGTH = 10;
	private static final int ADDRESS_LENGTH = 30;
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact() {
		setContactID("123456ABCD");
		setFirstName("Randy");
		setLastName("Marcelino");
		setPhone("1234567890");
		setAddress("1234 Stone St Tampa FL 33512");
	}
	
	public Contact(String contactID) {
		setContactID(contactID);
		setFirstName("Randy");
		setLastName("Marcelino");
		setPhone("1234567890");
		setAddress("1234 Stone St Tampa FL 33512");
	}
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setContactID(String contactID) {
		    if (contactID == null || contactID.length() > ID_LENGTH) {
		      throw new IllegalArgumentException("ID cannot be longer than " + ID_LENGTH + " characters or null");
		    } else {
		      this.contactID = contactID;
		    }
		  }
	
	public void setFirstName(String firstName) {
	    if (firstName == null || firstName.length() > FIRST_NAME_LENGTH) {
	        throw new IllegalArgumentException("First name cannot be longer than " + FIRST_NAME_LENGTH + " characters or null");
	      } else {
	        this.firstName = firstName;
	      }
	    }
	
	public void setLastName(String lastName) {
	    if (lastName == null || lastName.length() > LAST_NAME_LENGTH) {
	        throw new IllegalArgumentException("Last name cannot be longer than " + LAST_NAME_LENGTH + " characters or null");
	      } else {
	        this.lastName = lastName;
	      }	
	    }
	
	public void setPhone(String phone) {
	    String regex = "[0-9]+";
	    if (phone == null || phone.length() != PHONE_LENGTH) {
	      throw new IllegalArgumentException("Phone number length invalid. Phone Number must be " + PHONE_LENGTH + " digits and cannot be null.");
	    } else if (!phone.matches(regex)) {
	      throw new IllegalArgumentException("Phone number can only be numbers");
	    } else {
	      this.phone = phone;
	    }	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > ADDRESS_LENGTH) {
	        throw new IllegalArgumentException("Address cannot be longer than " + ADDRESS_LENGTH + " characters or null");
	      } else {
	        this.address = address;
	      }
		}
}
