package cabz.dao;

import java.util.List;

import cabz.dto.Driver;
import cabz.dto.Trip;
import cabz.dto.Vehicle;

public interface VendorModuleDataAccess {
	
	public List<Vehicle> getVendorsVehicles(String email);
	
	public List<Driver> getVendorsDrivers(String email);

	public Vehicle getVehicleByRegistrationNo(String registrationNo);
	
	public void createUpdateVehicle(Vehicle vehicle);
	
	public Trip getTripDetailsById(String tripId);
	
	public void updateTripDetails(Trip trip);
}
