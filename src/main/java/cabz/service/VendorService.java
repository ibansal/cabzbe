package cabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabz.dao.VendorModuleDataAccess;
import cabz.dto.Driver;
import cabz.dto.User;
import cabz.dto.Vehicle;


@Service
public class VendorService {
	
	@Autowired
	VendorModuleDataAccess vendorModuleDataAccess;

	public List<Vehicle> getVehiclesByVendor(String email) {
		return vendorModuleDataAccess.getVendorsVehicles(email);
	}
	
	public List<Driver> getDriversByVendor(String email) {
		return vendorModuleDataAccess.getVendorsDrivers(email);
	}
	
	
	
}

