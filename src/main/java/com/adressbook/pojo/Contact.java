package com.adressbook.pojo;

public class Contact {
	private String contactName;
	private String phoneNumber;

	public Contact(String contactName, String phoneNumber) {
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contact) {
			return this.getContactName().equals(((Contact) obj).getContactName());
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return this.getContactName().hashCode();
	}
}
