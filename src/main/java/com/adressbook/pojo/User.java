package com.adressbook.pojo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class User {

	private Map<String, AddressBook> addressBooks = new HashMap<String, AddressBook>();

	public AddressBook getAddressBook(String addressBookName) {
		return this.addressBooks.get(addressBookName);

	}

	public void createNewAddressBook(String addressBookName) {
		this.addressBooks.put(addressBookName, new AddressBook(addressBookName));

	}

	public void addContactToAddressBook(String addressBookName, String contactName, String phoneNumber) {
		if (this.addressBooks.containsKey(addressBookName)) {
			this.getAddressBook(addressBookName).addToAddressBook(contactName, phoneNumber);
		}
	}

	public String searchContact(String addressBookName, String contactName) {
		String phoneNumber = null;
		if (this.addressBooks.containsKey(addressBookName)
				&& this.addressBooks.get(addressBookName).getContacts().containsKey(contactName)) {
			phoneNumber = this.addressBooks.get(addressBookName).getContacts().get(contactName).getPhoneNumber();
		}
		return phoneNumber;
	}

	public void removeContactFromAddressBook(String addressBookName, String contactName) {
		if (this.addressBooks.containsKey(addressBookName)
				&& this.addressBooks.get(addressBookName).getContacts().containsKey(contactName)) {
			this.addressBooks.get(addressBookName).getContacts().remove(contactName);
		}

	}

	public Map<String, AddressBook> getAllAddressBooks() {
		// TODO Auto-generated method stub
		return this.addressBooks;
	}

	public Set<Contact> getUniqueContactsFromAllAddressBooks() {
		Set<Contact> uniqueContacts = new HashSet<Contact>();
		Iterator<Map.Entry<String, AddressBook>> addressBooksItr= this.addressBooks.entrySet().iterator();
		while(addressBooksItr.hasNext()){
			AddressBook addressBook = addressBooksItr.next().getValue();
			Iterator<Map.Entry<String, Contact>> contactsItr= addressBook.getContacts().entrySet().iterator();
			while(contactsItr.hasNext()){
				Contact contact =  contactsItr.next().getValue();
				uniqueContacts.add(contact);
			}
		}
		return uniqueContacts;
	}

}
