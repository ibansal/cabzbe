package cabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cabz.common.JsonRestObject;
import cabz.constants.UserType;
import cabz.dto.User;
import cabz.service.AccountService;


@Controller
@RequestMapping("/account")
public class AccountServiceController {

	@Autowired 
	private AccountService accountService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/verify_email", method = RequestMethod.GET)
	@RequestMapping(value = "/verify_mobile", method = RequestMethod.GET)
	@RequestMapping(value = "/otp_verify", method = RequestMethod.GET)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	
	
}
