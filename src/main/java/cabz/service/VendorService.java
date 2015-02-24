package cabz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cabz.common.JsonResponseObject;
import cabz.constants.ServiceCategory;
import cabz.dao.VendorModuleDataAccess;
import cabz.dto.Driver;
import cabz.dto.Inspection;
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
			, ServiceCategory vehicleType, String vehicleCompany, Inspection inspection, List<String> images, String gpsDetails){
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
			, ServiceCategory vehicleType, String vehicleCompany, Inspection inspection, List<String> images, String gpsDetails){
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

//	public String associateCab2Trip(String registrationNo, String tripId){
//		
//	}
//	

}

