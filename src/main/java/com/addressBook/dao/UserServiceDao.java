package com.addressBook.dao;

import java.util.HashMap;
import java.util.Map;

import com.adressbook.pojo.IAddressBookDao;

public class UserServiceDao implements IAddressBookDao {
	private static Map<String, String> validUsers = new HashMap<String, String>();
	static{
		validUsers.put("userName", "password");
	}


	@Override
	public boolean authenticateUser(String userName, String password) {
		return (validUsers.containsKey(userName) && validUsers.get(userName).equals(password));
		
	}

}
