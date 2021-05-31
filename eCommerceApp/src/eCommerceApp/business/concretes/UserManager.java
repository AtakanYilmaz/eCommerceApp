package eCommerceApp.business.concretes;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceApp.business.abstracts.UserService;
import eCommerceApp.core.AuthService;
import eCommerceApp.dataAccess.abstracts.UserDao;
import eCommerceApp.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private AuthService authService;
	

	public UserManager(UserDao userDao, AuthService authService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length() <= 6 ) {
			System.out.println("þifre en az 6 karakterden oluþmalýdýr");
		}
		final String EMAIL_PATTERN = "^[A-Za-z0-9_.-]+@(.+)$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			System.out.println(user.getEmail() + " bu e-posta, formatýna uygun deðil");
		}
		for(User users:userDao.getAll()) {
			if(users.getEmail().equals(user.getEmail())) {
				System.out.println(user.getEmail()+ " bu e-posta adresi mevcuttur");
			}
		}
		
		if (user.getFirstName().length() <= 2 && user.getLastName().length() <= 2) {
			System.out.println("Ad ve soyad en az 2 karakterden oluþmalýdýr");
		}
		
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(User user) {
		if (user.isVerify()==true) {
			userDao.login(user);
		}else {
			System.out.println("Giriþ baþarýsýz email adresinizi kontrol ediniz.");
		}
		
	}

	@Override
	public void confirm(User user) {
		if (user.isVerify()==true) {
			userDao.confirm(user);
			System.out.println("E-posta adresiniz doðrulanmýþtýr");
		}else {
			System.out.println("E-posta adresiniz doðrulanmamýþtýr");
		}
	}

	@Override
	public void registerwithAccount(User user) {
		user.setVerify(true);
		this.authService.register(user);
		
		
	}

	@Override
	public void loginWithAccount(User user) {
		if (user.isVerify()==true) {
			this.authService.login(user);
		}else {
			System.out.println("Henüz kayýt olunmamýþtýr");
		}
		
	}

}
