package eCommerceApp;

import GoogleAuth.GoogleAuthManager;
import eCommerceApp.business.abstracts.UserService;
import eCommerceApp.business.concretes.UserManager;
import eCommerceApp.core.GoogleAuthManagerAdapter;
import eCommerceApp.dataAccess.concretes.HiberNetUserDao;
import eCommerceApp.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HiberNetUserDao(),
				new GoogleAuthManagerAdapter(new GoogleAuthManager()));
		User user = new User("Atakan", "Yýlmaz", "atakan3696", "hatakanyilmaz@hotmail.com", true);
		User user1 = new User("Faruk", "Düzkoþar", "1234567", "duzkosar@gmail.com", true);
		
		userService.register(user);
		userService.login(user);
		userService.confirm(user);
		userService.registerwithAccount(user1);
		userService.loginWithAccount(user1);
	}

}
