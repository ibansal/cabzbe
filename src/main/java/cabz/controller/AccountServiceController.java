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
     public @ResponseBody JsonRestObject createUser(@RequestParam("email") String email,@RequestParam("mobileno") String mobileno
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
	

	@RequestMapping(value = "/checkifemailunique", method = RequestMethod.GET)
    public @ResponseBody JsonRestObject checkIfEmailUnique(@RequestParam("email") String email) {
        
		boolean isEmailExsist=accountService.isEmailAlreadyExist(email);
		return new JsonRestObject(isEmailExsist);
    }
	
	@RequestMapping(value = "/checkifmobileunique", method = RequestMethod.GET)
    public @ResponseBody JsonRestObject checkIfMobileUnique(@RequestParam("mobile") String mobileNo) {
        
		boolean isEmailExsist=accountService.isEmailAlreadyExist(mobileNo);
		return new JsonRestObject(isEmailExsist);
    }
	
	@RequestMapping(value = "/verifyOtp", method = RequestMethod.GET)
    public @ResponseBody JsonRestObject verifyOtp(@RequestParam("otp") String otp, @RequestParam("userId") String userId) {
        
		boolean isValidated=accountService.validateOTP(otp, userId);
		return new JsonRestObject(isValidated);
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody JsonRestObject login(@RequestParam("email") String email, @RequestParam("password") String password) {
        
		boolean isValidated=accountService.validateOTP(email, password);
		return new JsonRestObject(isValidated);
    }
	
}
