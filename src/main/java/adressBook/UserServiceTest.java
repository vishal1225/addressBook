package adressBook;

import com.addressBook.dao.UserServiceDao;
import com.addressBook.service.UserService;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase{
	
	public void testUserLogin(){
		UserService userService = UserService.getUserService();
		userService.setUserServiceDao(new UserServiceDao());
		assertTrue(userService.authenticateUser("userName","password"));
	}

}
