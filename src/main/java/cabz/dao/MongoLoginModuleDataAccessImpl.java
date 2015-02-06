package cabz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import cabz.dto.User;

public class MongoLoginModuleDataAccessImpl implements LoginModuleDataAccess{
	
	 @Autowired
	 private MongoTemplate mongoCabzDB;

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
		user.setLastUpdated(System.currentTimeMillis());
		mongoCabzDB.save(user);
		
	}

	@Override
	public boolean isEmailIDExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMobileExist(String mobileNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateOTP(String otp) {
		// TODO Auto-generated method stub
		return false;
	}

}
