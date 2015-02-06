package cabz.dao;

import cabz.dto.User;

public interface LoginModuleDataAccess {
	
	public void createUser(User user);
	
	public boolean isEmailIDExist(String email);
	
	public boolean isMobileExist(String mobileNo);
	
	public boolean validateOTP(String otp);
	
	

}
