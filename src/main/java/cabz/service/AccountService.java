package cabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import cabz.dto.User;

@Service
public class AccountService {

	 @Autowired
	 private MongoTemplate mongoCabzDB;
	
	
	public void createAccount(User user){
		user.setLastUpdated(System.currentTimeMillis());
		mongoCabzDB.save(user);
	}
	
}
