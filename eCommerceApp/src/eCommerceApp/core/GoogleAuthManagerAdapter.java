package eCommerceApp.core;

import GoogleAuth.GoogleAuthManager;
import eCommerceApp.entities.concretes.User;

public class GoogleAuthManagerAdapter implements AuthService {
	
	GoogleAuthManager googleAuthManager;
	
	public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
		this.googleAuthManager = googleAuthManager;
	}

	@Override
	public void register(User user) {
		googleAuthManager.register(user);
		
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
		
	}
	
}
