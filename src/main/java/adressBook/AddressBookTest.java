package adressBook;

import com.adressbook.pojo.AddressBook;
import com.adressbook.pojo.User;

import junit.framework.TestCase;

public class AddressBookTest extends TestCase {
	// Address book will hold name and phone numbers of contact entries
	public void testAddressBook() {
		AddressBook addressBook = new AddressBook("addressBook1");
		addressBook.addToAddressBook("contactName", "phoneNumber");
		assertNotNull(addressBook.getContacts().get("contactName"));
	}

	// Users should be able to add new contact entries
	public void testAddToAddressBook() {
		User user = new User();
		user.createNewAddressBook("addressBookName");
		assertNotNull(user.getAddressBook("addressBookName"));
		user.addContactToAddressBook("addressBookName", "contactName", "phoneNumber");
		assertNotNull(user.searchContact("addressBookName", "contactName"));
	}

	// Users should be able to remove existing contact entries
	public void testRemoveContactFromAddressBook() {
		User user = new User();
		user.createNewAddressBook("addressBookName");
		assertNotNull(user.getAddressBook("addressBookName"));
		user.addContactToAddressBook("addressBookName", "contactName", "phoneNumber");
		assertNotNull(user.searchContact("addressBookName", "contactName"));
		user.removeContactFromAddressBook("addressBookName", "contactName");
		assertNull(user.searchContact("addressBookName", "contactName"));
	}

	// Users should be able to print all contacts in an address book
	public void testGetAllContactsFromAddressBook() {
		User user = new User();
		user.createNewAddressBook("addressBookName");
		assertNotNull(user.getAddressBook("addressBookName"));
		user.addContactToAddressBook("addressBookName", "firstContact", "1212365548");
		user.addContactToAddressBook("addressBookName", "secondContact", "78789588465");
		user.addContactToAddressBook("addressBookName", "thirdContact", "5858652285");
		assertEquals(user.getAddressBook("addressBookName").getContacts().size(), 3);
	}

	// Users should be able to maintain multiple address books
	public void testMultipleAddressBooks() {
		User user = new User();
		user.createNewAddressBook("addressBook1");
		user.createNewAddressBook("addressBook2");
		user.createNewAddressBook("addressBook3");
		assertEquals(user.getAllAddressBooks().size(), 3);
	}
	// Users should be able to print a unique set of all contacts across
	// multiple address books
	public void testGetUniqueContactsFromAllAddressBooks() {
		User user = new User();
		user.createNewAddressBook("addressBook1");
		user.addContactToAddressBook("addressBook1", "firstContact", "1212365548");
		user.createNewAddressBook("addressBook2");
		user.addContactToAddressBook("addressBook2", "firstContact", "1212365548");
		user.createNewAddressBook("addressBook3");
		user.addContactToAddressBook("addressBook3", "firstContact", "1212365548");
		assertEquals(user.getUniqueContactsFromAllAddressBooks().size(), 1);
	}
	
	
}
