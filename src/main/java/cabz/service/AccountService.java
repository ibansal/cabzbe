package cabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.QueryBuilder;

import cabz.constants.UserType;
import cabz.dao.LoginModuleDataAccess;
import cabz.dto.User;

@Service
public class AccountService {
	
	@Autowired
	LoginModuleDataAccess loginModuleDataAccess;
	
	
	public void createAccount(User user){
		user.setLastUpdated(System.currentTimeMillis());
		user.setOtp(generateOTP());
		user.setReferralCode(generateRefferalCode());
		loginModuleDataAccess.createUser(user);
		//send the otp via sms
		sendOTP(user.getMobileno());
	}
	
	public User getUserMobileNo(String mobileNo){
		return loginModuleDataAccess.getUserByMobileNo(mobileNo);
	}
	
	public User getUserByEmail(String emailId){
		return loginModuleDataAccess.getUserByEmail(emailId);
	}
	
	private void sendOTP(String mobileno) {
		// TODO code to send the otp via password
	}

	public String generateOTP(){
		//TODO:logic to create otp
		return "0000";
	}
	
	public String generateRefferalCode(){
		//TODO:logic to generate refferal code
		return "HELLO";
	}
	
	public boolean isEmailAlreadyExist(String emailId){
		return loginModuleDataAccess.isEmailIDExist(emailId);	
		
	}
	
	public boolean isMobileAlreadyExist(String mobileNo){
		return loginModuleDataAccess.isMobileExist(mobileNo);	
	}
	
	public boolean validateOTP(String otp, String emailId){
		return loginModuleDataAccess.validateOTP(otp, emailId);	
	}
	
	public boolean login(String email, String password){
		return loginModuleDataAccess.verifyUser(email, password);
	}
	
	public void updateProfile(String email, String mobileNo, String userType, String password){
		User user = getUserByEmail(email);
		user.setMobileno(mobileNo);
		UserType type = UserType.valueOf(userType);
		user.setUserType(type);
		user.setPassword(password);
		loginModuleDataAccess.updateUser(user);
	}
	
}
