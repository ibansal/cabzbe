package cabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/api")
@Secured("ROLE_USER")
public class BookingController {
	@Autowired 
	private AccountService accountService;
	
	@RequestMapping(value = "/booking/new", method = RequestMethod.POST)
    public @ResponseBody JsonRestObject createBooking(@RequestParam("email") String email,@RequestParam("mobileno") String mobileno
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
