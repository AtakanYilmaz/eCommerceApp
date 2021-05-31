package eCommerceApp.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceApp.dataAccess.abstracts.UserDao;
import eCommerceApp.entities.concretes.User;

public class HiberNetUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println(user.getFirstName() + " isimli kullan�c� ba�ar�l� bir �ekilde kaydolmu�");
		users.add(user);
	}

	@Override
	public void login(User user) {
		System.out.println(user.getFirstName()+ " adl� kullan�c� giri� yapt�");
		
	}

	@Override
	public void confirm(User user) {
		System.out.println(user.getEmail()+ " email adresiniz onayland�");
		user.setVerify(true);
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
