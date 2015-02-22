package cabz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import cabz.dto.User;
import static cabz.constants.JSONKeyNames.*;

public class MongoLoginModuleDataAccessImpl implements LoginModuleDataAccess{
	
	 @Autowired
	 private MongoTemplate mongoCabzDB;

	public void createUser(User user) {
		user.setLastUpdated(System.currentTimeMillis());
		mongoCabzDB.save(user);
	}
	
	public void updateUser(User user) {
		user.setLastUpdated(System.currentTimeMillis());
		mongoCabzDB.save(user);
	}

	public boolean isEmailIDExist(String email) {
		MongoOperations oper = mongoCabzDB;
        long count = oper.count(Query.query(Criteria.where(EMAIL_ID).is(email)), User.class);
        return count > 0;
	}

	public boolean isMobileExist(String mobileNo) {
		MongoOperations oper = mongoCabzDB;
        long count = oper.count(Query.query(Criteria.where(MOBILE_NO).is(mobileNo)), User.class);
        return count > 0;
	}

	public boolean validateOTP(String otp, String email) {
		MongoOperations oper = mongoCabzDB;
		Query query = Query.query(Criteria.where(OTP).is(otp).and(EMAIL_ID).is(email));
		long count = oper.count(query, User.class);
		if(count > 0){
			oper.updateMulti(query, Update.update(IS_VERIFIED, true), User.class);
		}
        return count > 0;
	}

	public boolean verifyUser(String email, String password) {
		MongoOperations oper = mongoCabzDB;
        long count = oper.count(Query.query(Criteria.where(EMAIL_ID).is(email).and(PASSWORD).is(password)), User.class);
        return count > 0;
		
	}

	public User getUserByMobileNo(String mobileNo) {
		MongoOperations oper = mongoCabzDB;
		return oper.findOne(Query.query(Criteria.where(MOBILE_NO).is(mobileNo)), User.class);
	}

	public User getUserByEmail(String email) {
		MongoOperations oper = mongoCabzDB;
        return oper.findOne(Query.query(Criteria.where(EMAIL_ID).is(email)), User.class);
	}

}
