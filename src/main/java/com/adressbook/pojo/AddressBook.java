package com.adressbook.pojo;

import java.util.HashMap;
import java.util.Map;

public class AddressBook {
	private String addressBookName;
	public String getAddressBookName() {
		return addressBookName;
	}

	private Map<String, Contact> contacts = new HashMap<String, Contact>();

	public AddressBook(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public Map<String, Contact> getContacts() {
		return contacts;
	}

	public void addToAddressBook(String contactName, String phoneNumber) {
		this.contacts.put(contactName, new Contact(contactName,phoneNumber));
	}
}
