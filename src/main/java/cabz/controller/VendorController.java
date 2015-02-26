package cabz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cabz.common.JsonResponseObject;
import cabz.common.JsonRestObject;
import cabz.constants.ServiceCategory;
import cabz.dto.Driver;
import cabz.dto.Inspection;
import cabz.dto.Trip;
import cabz.dto.User;
import cabz.dto.Vehicle;
import cabz.service.AccountService;
import cabz.service.VendorService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired 
	private VendorService vendorService;

	@Autowired 
	private AccountService accountService;


	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public @ResponseBody String getProfile(@RequestParam("email") String email, @RequestParam("password") String password) {

		User user = accountService.getUserByEmail(email);
		Gson gson = new Gson();
		String userJson = gson.toJson(user);
		return userJson;
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public @ResponseBody String getInventory(@RequestParam("email") String email) {
		List<Vehicle> vehicles = vendorService.getVehiclesByVendor(email);
		Gson gson = new Gson();	
		return gson.toJson(vehicles);
	}

	@RequestMapping(value = "/driverlist", method = RequestMethod.GET)
	public @ResponseBody String getDrivers(@RequestParam("email") String email) {
		List<Driver> drivers = vendorService.getDriversByVendor(email);
		Gson gson = new Gson();
		return gson.toJson(drivers);
	}

	@RequestMapping(value = "/updatecab", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject updateCab(@RequestParam("email") String email,
			@RequestParam("registrationNo") String registrationNo,@RequestParam("makeYear") String makeYear,
			@RequestParam("dateOfRegistration") long dateOfRegistration,@RequestParam("vehicleType") ServiceCategory vehicleType,
			@RequestParam("vehicleCompany") String vehicleCompany,@RequestParam("inspections") Inspection inspections,
			@RequestParam("images") List<String> image,@RequestParam("gpsDetails") String gpsDetails) {

		JsonResponseObject jsonResponseObject = vendorService.updateCabDetails(email,registrationNo,makeYear,dateOfRegistration,vehicleType,vehicleCompany,inspections,image,gpsDetails);
		return jsonResponseObject;
	}

	@RequestMapping(value = "/addnewcab", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject addNewCab(@RequestParam("email") String email,
			@RequestParam("registrationNo") String registrationNo,@RequestParam("makeYear") String makeYear,
			@RequestParam("dateOfRegistration") long dateOfRegistration,@RequestParam("vehicleType") ServiceCategory vehicleType,
			@RequestParam("vehicleCompany") String vehicleCompany,@RequestParam("inspections") Inspection inspections,
			@RequestParam("images") List<String> image,@RequestParam("gpsDetails") String gpsDetails) {

		JsonResponseObject jsonResponseObject = vendorService.addNewCabDetails(email,registrationNo,makeYear,dateOfRegistration,vehicleType,vehicleCompany,inspections,image,gpsDetails);
		return jsonResponseObject;
	}

	@RequestMapping(value = "/updatecabfortrip", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject updatecabfortrip(@RequestParam("registrationNo") String registrationNo,@RequestParam("tripId") String tripId) {
		JsonResponseObject updateCab2Trip = vendorService.updateCab4Trip(registrationNo, tripId);
		return updateCab2Trip;
	}

	@RequestMapping(value = "/updatedriverfortrip", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject updatedriverfortrip(@RequestParam("driverId") String driverId,@RequestParam("tripId") String tripId) {
		JsonResponseObject updateCab2Trip = vendorService.updateCab4Trip(driverId, tripId);
		return updateCab2Trip;
	}
	
	@RequestMapping(value = "/acceptbooking", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject acceptBooking(@RequestParam("email") String email) {
		//TODO: to be done after booking code is implemented
		return new JsonRestObject(true);
	}

	@RequestMapping(value = "/rejectbooking", method = RequestMethod.POST)
	public @ResponseBody JsonRestObject rejectBooking(@RequestParam("email") String email) {
		//TODO: to be done after booking code is implemented
		return new JsonRestObject(true);
	}
	
	@RequestMapping(value = "/getupcommingtrips", method = RequestMethod.GET)
	public @ResponseBody String getUpcommingTrips(@RequestParam("email") String vendorEmail,@RequestParam("count") int count,@RequestParam("pos") int pos) {
		List<Trip> upcommingTrips = vendorService.getUpcommingTrips(vendorEmail, count, pos);
		Gson gson = new Gson();
		String tripsJson = gson.toJson(upcommingTrips);
		return tripsJson;
	}
	
	@RequestMapping(value = "/getpasttrips", method = RequestMethod.GET)
	public @ResponseBody String getpastTrips(@RequestParam("email") String vendorEmail,@RequestParam("count") int count,@RequestParam("pos") int pos) {
		List<Trip> upcommingTrips = vendorService.getPastTrips(vendorEmail, count, pos);
		Gson gson = new Gson();
		String tripsJson = gson.toJson(upcommingTrips);
		return tripsJson;
	}

	@RequestMapping(value = "/createdeal", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject createDeal(@RequestParam("email") String email,
			@RequestParam("dealTime") long dealTime,@RequestParam("source") String source,
			@RequestParam("destination") String destination,@RequestParam("vehicle") String vehicleRegistrationNo,
			@RequestParam("driverId") String driverId){
		
		return vendorService.createNewDeal(email, dealTime, source, destination,vehicleRegistrationNo, driverId);
	}

	@RequestMapping(value = "/updatedeal", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject updateDeal(@RequestParam("email") String email,
			@RequestParam("dealTime") long dealTime,@RequestParam("source") String source,
			@RequestParam("destination") String destination,@RequestParam("vehicle") String vehicleRegistrationNo,
			@RequestParam("driverId") String driverId, @RequestParam("dealId") String dealId){
		return vendorService.updateDeal(email, dealTime, source, destination,vehicleRegistrationNo, driverId, dealId);
	}

	@RequestMapping(value = "/deletedeal", method = RequestMethod.POST)
	public @ResponseBody JsonResponseObject deleteDeal(@RequestParam("email") String email, @RequestParam("dealId") String dealId){
		return vendorService.deleteDeal(email, dealId);
	}

	

}
