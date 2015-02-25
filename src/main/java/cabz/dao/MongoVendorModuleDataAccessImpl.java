package cabz.dao;

import static cabz.constants.JSONKeyNames.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import cabz.dto.Driver;
import cabz.dto.Trip;
import cabz.dto.User;
import cabz.dto.Vehicle;

public class MongoVendorModuleDataAccessImpl implements VendorModuleDataAccess{

	@Autowired
	private MongoTemplate mongoCabzDB;


	public List<Vehicle> getVendorsVehicles(String email) {
		MongoOperations oper = mongoCabzDB;
		return  oper.find(Query.query(Criteria.where(VENDOR_EMAIL).is(email)), Vehicle.class);
	}


	public List<Driver> getVendorsDrivers(String email) {
		MongoOperations oper = mongoCabzDB;
		return  oper.find(Query.query(Criteria.where(VENDOR_EMAIL).is(email)), Driver.class);
	}


	public Vehicle getVehicleByRegistrationNo(String registrationNo) {
		MongoOperations oper = mongoCabzDB;
		return  oper.findOne(Query.query(Criteria.where(REGISTRATION_NO).is(registrationNo)), Vehicle.class);
	}


	public void createUpdateVehicle(Vehicle vehicle) {
		vehicle.setLastUpdated(System.currentTimeMillis());
		mongoCabzDB.save(vehicle);

	}


	public Trip getTripDetailsById(String id) {
		MongoOperations oper = mongoCabzDB;
		return  oper.findOne(Query.query(Criteria.where(ID).is(id)), Trip.class);
	}


	public void updateTripDetails(Trip trip) {
		trip.setLastUpdated(System.currentTimeMillis());
		mongoCabzDB.save(trip);
	}

}
