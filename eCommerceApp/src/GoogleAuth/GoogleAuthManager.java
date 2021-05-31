package GoogleAuth;

import eCommerceApp.core.AuthService;
import eCommerceApp.entities.concretes.User;

public class GoogleAuthManager implements AuthService {
	public void register(User user) {
		System.out.println("Google hesabý ile kayýt olundu");
	}
	
	public void login(User user) {
		System.out.println("Google hesabý ile giriþ yapýldý");
	}
}
