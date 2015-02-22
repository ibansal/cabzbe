package cabz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cabz.common.JsonRestObject;
import cabz.dto.User;
import cabz.dto.Vehicle;
import cabz.service.AccountService;
import cabz.service.VendorService;


@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired 
	private VendorService vendorService;

	@Autowired 
	private AccountService accountService;


	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody JsonRestObject getProfile(@RequestParam("email") String email, @RequestParam("password") String password) {

		User user = accountService.getUserByEmail(email);
		//TODO: return json object, use gson
		//return user.toString();
		return new JsonRestObject(true);
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public @ResponseBody JsonRestObject getInventory(@RequestParam("email") String email) {
		List<Vehicle> vehicles = vendorService.getVehiclesByVendor(email);
//		Gson gson = new Gson();	
//		gson.toJson(vehicles);
		return new JsonRestObject(true);
	}

	@RequestMapping(value = "/driverlist", method = RequestMethod.GET)
	public @ResponseBody JsonRestObject getDrivers(@RequestParam("email") String email) {
		List<Vehicle> vehicles = vendorService.getVehiclesByVendor(email);
		//return user.toString();
		return new JsonRestObject(true);
	}

	//TODO: check the kind of params needed for this methos
	@RequestMapping(value = "/updatecab", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject updateCab(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}

	//TODO: check the kind of params needed for this methos
	@RequestMapping(value = "/addnewcab", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject addNewCab(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}

	//TODO: check the kind of params needed for this methos
	@RequestMapping(value = "/associatecab", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject associateCab(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}

	//TODO: check the kind of params needed for this methos
	@RequestMapping(value = "/disassociatecab", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject disassociateCab(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}

	//TODO: check the kind of params needed for this methos
	@RequestMapping(value = "/adddriver", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject addDriver(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/updatedriverdetails", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject updateDriverDetails(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/associatedrivertoride", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject associateDriverToRide(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/updatedrivertoride", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject updateDriverToRide(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/getupcommingrides", method = RequestMethod.GET)
	public @ResponseBody JsonRestObject getUpcommingRides(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/createdeal", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject createDeal(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/updatedeal", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject updateDeal(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/deletedeal", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject deleteDeal(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/associatecabtoride", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject associateCabToRide(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/updatecabtoride", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject updateCabToRide(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/acceptbooking", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject acceptBooking(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/rejectbooking", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject rejectBooking(@RequestParam("email") String email) {
		//TODO: update details for the particular cab
		return new JsonRestObject(true);
	}
	
}
