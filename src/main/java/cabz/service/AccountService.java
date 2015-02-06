package cabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.QueryBuilder;

import cabz.dao.LoginModuleDataAccess;
import cabz.dto.User;

@Service
public class AccountService {
	
	@Autowired
	LoginModuleDataAccess loginModuleDataAccess;
	
	
	public void createAccount(User user){
		user.setLastUpdated(System.currentTimeMillis());
		loginModuleDataAccess.createUser(user);
		
		
	}
	
	public boolean isEmailAlreadyExist(String emailId){
		boolean validateEmail=false;
		return loginModuleDataAccess.isEmailIDExist(emailId)	;	
		
	}
	
}
