package cabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cabz.common.JsonRestObject;
import cabz.dto.User;
import cabz.dto.UserType;
import cabz.service.AccountService;


@Controller
@RequestMapping("/account")
public class AccountServiceController {

	@Autowired 
	private AccountService accountService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public @ResponseBody JsonRestObject getJsonRestObject(@RequestParam("email") String email,@RequestParam("mobileno") String mobileno
    		,@RequestParam("userType") String userType, @RequestParam("password") String password) {
        
		User user = new User();
		user.setEmail(email);
		user.setMobileno(mobileno);
		user.setPassword(password);
		UserType type = UserType.valueOf(userType);
		user.setUserType(type);
		accountService.createAccount(user);
		
		return new JsonRestObject(true);
    }
}
