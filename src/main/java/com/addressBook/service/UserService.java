package com.addressBook.service;

import com.adressbook.pojo.IAddressBookDao;

public class UserService {

	private static UserService userService = null;
	private IAddressBookDao userServiceDao;

	public IAddressBookDao getUserServiceDao() {
		return userServiceDao;
	}

	public void setUserServiceDao(IAddressBookDao userServiceDao) {
		this.userServiceDao = userServiceDao;
	}

	private UserService() {
	}

	public static UserService getUserService() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public boolean authenticateUser(String userName, String password) {
		return userServiceDao.authenticateUser(userName, password);

	}

}
