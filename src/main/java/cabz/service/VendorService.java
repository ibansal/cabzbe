package cabz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.gson.JsonObject;

import cabz.common.JsonResponseObject;
import cabz.common.Utils;
import cabz.dao.VendorModuleDataAccess;
import cabz.dto.CategoryOfVehicle;
import cabz.dto.Deal;
import cabz.dto.Driver;
import cabz.dto.Inspection;
import cabz.dto.Trip;
import cabz.dto.Vehicle;


@Service
public class VendorService {

	@Autowired
	VendorModuleDataAccess vendorModuleDataAccess;

	private static final Logger logger               = LoggerFactory.getLogger(VendorService.class.getCanonicalName());

	public List<Vehicle> getVehiclesByVendor(String email) {
		return vendorModuleDataAccess.getVendorsVehicles(email);
	}

	public List<Driver> getDriversByVendor(String email) {
		return vendorModuleDataAccess.getVendorsDrivers(email);
	}

	public JsonResponseObject updateCabDetails(String email, String registrationNo, String makeYear, long dateOfRegistration
			, CategoryOfVehicle vehicleType, String vehicleCompany, Inspection inspection, List<String> images, String gpsDetails){
		Vehicle vehicle = vendorModuleDataAccess.getVehicleByRegistrationNo(registrationNo);
		if(vehicle != null){
			if(StringUtils.isNotBlank(email)){
				if(!email.equalsIgnoreCase(vehicle.getVendorEmail())){
					logger.info("Vendors email not matching with registration no "+registrationNo+" vendor email "+email);
					return new JsonResponseObject("Vendors email not matching with registration no", false);
				}
			}
			if(StringUtils.isNotBlank(makeYear)){
				vehicle.setMakeYear(makeYear);
			}
			if(dateOfRegistration > 0){
				vehicle.setDateOfRegistration(dateOfRegistration);;
			}
			if(vehicleType != null){
				vehicle.setVehicleType(vehicleType);
			}
			if(StringUtils.isNotBlank(vehicleCompany)){
				vehicle.setVehicleCompany(vehicleCompany);
			}
			if(inspection != null){
				List<Inspection> inspections = vehicle.getInspections();
				if(CollectionUtils.isEmpty(inspections)){
					inspections = new ArrayList<Inspection>();
				}
				inspections.add(inspection);
				vehicle.setInspections(inspections);
			}
			if(!CollectionUtils.isEmpty(images)){
				List<String> prevImages = vehicle.getImages();
				if(CollectionUtils.isEmpty(prevImages)){
					prevImages = new ArrayList<String>();
				}
				prevImages.addAll(images);
				vehicle.setImages(prevImages);
			}
			if(StringUtils.isNotBlank(gpsDetails)){
				vehicle.setGpsDetails(gpsDetails);
			}
			vendorModuleDataAccess.createUpdateVehicle(vehicle);
			return new JsonResponseObject("success", true);
		}
		logger.error("vehicle not found with registration no "+ registrationNo);
		return new JsonResponseObject("vehicle not found", false);
	}

	public JsonResponseObject addNewCabDetails(String email, String registrationNo, String makeYear, long dateOfRegistration
			, CategoryOfVehicle vehicleType, String vehicleCompany, Inspection inspection, List<String> images, String gpsDetails){
		Vehicle vehicle = vendorModuleDataAccess.getVehicleByRegistrationNo(registrationNo);
		if(StringUtils.isBlank(registrationNo)){
			logger.error("registration no is emapty "+ registrationNo+" email "+email);
			return new JsonResponseObject("registration no is emapty, please contact customer service", false);
		}
		if(vehicle != null){
			logger.error("vehicle already registered with registration no "+ registrationNo);
			return new JsonResponseObject("vehicle already registered, please contact customer service", false);
		}
		if(StringUtils.isBlank(email)){
			logger.error("vendors email is empty "+ registrationNo+" email "+email);
			return new JsonResponseObject("vendors email is empty, please contact customer service", false);
		}
		vehicle = new Vehicle();
		vehicle.setRegistrationNo(registrationNo);
		vehicle.setVendorEmail(email);
		if(StringUtils.isNotBlank(makeYear)){
			vehicle.setMakeYear(makeYear);
		}
		if(dateOfRegistration > 0){
			vehicle.setDateOfRegistration(dateOfRegistration);;
		}
		if(vehicleType != null){
			vehicle.setVehicleType(vehicleType);
		}
		if(StringUtils.isNotBlank(vehicleCompany)){
			vehicle.setVehicleCompany(vehicleCompany);
		}
		if(inspection != null){
			List<Inspection> inspections = new ArrayList<Inspection>();
			inspections.add(inspection);
			vehicle.setInspections(inspections);
		}
		if(!CollectionUtils.isEmpty(images)){
			List<String> prevImages = new ArrayList<String>();
			prevImages.addAll(images);
			vehicle.setImages(prevImages);
		}
		if(StringUtils.isNotBlank(gpsDetails)){
			vehicle.setGpsDetails(gpsDetails);
		}
		vendorModuleDataAccess.createUpdateVehicle(vehicle);
		return new JsonResponseObject("successfully added",true);
	}

	public JsonResponseObject updateCab4Trip(String registrationNo, String tripId){
		Trip trip = vendorModuleDataAccess.getTripDetailsById(tripId);
		if(trip == null){
			return new JsonResponseObject("Failed updating, trip not found",false);
		}
		trip.setVehicleRegistrationNo(registrationNo);
		vendorModuleDataAccess.updateTripDetails(trip);
		return new JsonResponseObject("Successfully updated",true);
	}
	
	public JsonResponseObject updateDriver4Trip(String driverId, String tripId){
		Trip trip = vendorModuleDataAccess.getTripDetailsById(tripId);
		if(trip == null){
			return new JsonResponseObject("Failed updating, trip not found",false);
		}
		trip.setDriverId(driverId);
		vendorModuleDataAccess.updateTripDetails(trip);
		return new JsonResponseObject("Successfully updated",true);
	}

	@SuppressWarnings("unchecked")
	public List<Trip> getUpcommingTrips(String vendorEmail, int count, int pos) {
		List<Trip> upcomingTrips = vendorModuleDataAccess.getUpcomingTrips(vendorEmail);
		return Utils.getSublistForPage(upcomingTrips, count, pos);
	}

	@SuppressWarnings("unchecked")
	public List<Trip> getPastTrips(String vendorEmail, int count, int pos) {
		List<Trip> upcomingTrips = vendorModuleDataAccess.getPastTrips(vendorEmail);
		return Utils.getSublistForPage(upcomingTrips, count, pos);
	}

	public JsonResponseObject createNewDeal(String email, long dealTime, String source,
			String destination, String vehicleRegistrationNo, String driverId) {
		Deal deal = new Deal();
		deal.setDealTime(dealTime);
		deal.setOriginTripId(email);
		deal.setSource(source);
		deal.setDestination(destination);
		deal.setDriverId(driverId);
		vendorModuleDataAccess.createUpdateDeal(deal);
		return new JsonResponseObject("Successfully created deal",true);
	}

	public JsonResponseObject updateDeal(String email, long dealTime,
			String source, String destination, String vehicleRegistrationNo,
			String driverId, String dealId) {

		Deal deal = vendorModuleDataAccess.getDealById(dealId);
		if(deal != null){
			if(StringUtils.isNotBlank(email)){
				if(!email.equalsIgnoreCase(deal.getOriginTripId())){
					logger.info("Vendors email not matching with deal ID "+dealId+" vendor email "+email);
					return new JsonResponseObject("Vendors email not matching with deal ID", false);
				}
			}
			if(StringUtils.isNotBlank(source)){
				deal.setSource(source);
			}
			if(StringUtils.isNotBlank(destination)){
				deal.setDestination(destination);
			}
			if(dealTime > 0){
				deal.setDealTime(dealTime);
			}	
			if(StringUtils.isNotBlank(vehicleRegistrationNo)){
				deal.setVehicleRegistrationNo(vehicleRegistrationNo);
			}
			if(StringUtils.isNotBlank(driverId)){
				deal.setDriverId(driverId);
			}
			vendorModuleDataAccess.createUpdateDeal(deal);
			return new JsonResponseObject("success", true);
		}
		logger.error("Deal not found with Id "+ dealId);
		return new JsonResponseObject("Deal not found", false);
	}

	public JsonResponseObject deleteDeal(String email, String dealId) {
		Deal deal = vendorModuleDataAccess.getDealById(dealId);
		if(deal != null && StringUtils.isNotBlank(email)){
			if(StringUtils.isNotBlank(email)){
				if(!email.equalsIgnoreCase(deal.getOriginTripId())){
					logger.info("Vendors email not matching with deal ID "+dealId+" vendor email "+email);
					return new JsonResponseObject("Vendors email not matching with deal ID", false);
				}
			}
			deal.setDeleted(true);
			vendorModuleDataAccess.createUpdateDeal(deal);
			return new JsonResponseObject("success", true);
		}
		logger.error("Deal not found with Id or vendor email empty"+ dealId);
		return new JsonResponseObject("Deal not found or vendor email empty", false);
	}

}

