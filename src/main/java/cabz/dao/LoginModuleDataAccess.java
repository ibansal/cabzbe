package cabz.dao;

import cabz.dto.User;

public interface LoginModuleDataAccess {
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public boolean isEmailIDExist(String email);
	
	public boolean isMobileExist(String mobileNo);
	
	public boolean validateOTP(String otp, String email);
	
	public boolean verifyUser(String email, String password);
	
	public User getUserByMobileNo(String mobileNo);
	
	public User getUserByEmail(String email);
	
}
