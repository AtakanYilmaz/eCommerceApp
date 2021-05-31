package eCommerceApp.business.abstracts;

import eCommerceApp.entities.concretes.User;

public interface UserService {
	void register(User user);

	void login(User user);

	void update(User user);

	void delete(User user);
	
	void confirm(User user);
	
	void registerwithAccount(User user);
	
	void loginWithAccount(User user);

}
