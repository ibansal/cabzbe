package cabz.dto;

import java.util.List;

import cabz.constants.ServiceCategory;

public class Vehicle {
	
	private String   id;

    private String   registrationNo;

    private String   makeYear;

    private long     dateOfRegistration;

    private ServiceCategory vehicleType;

    private List<String>   images;
    
    private String   vehicleCompany;
    
    private long	startDate;
    
    private List<Inspection> 	inspections;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}

	public long getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(long dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public ServiceCategory getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(ServiceCategory vehicleType) {
		this.vehicleType = vehicleType;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getVehicleCompany() {
		return vehicleCompany;
	}

	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public List<Inspection> getInspections() {
		return inspections;
	}

	public void setInspections(List<Inspection> inspections) {
		this.inspections = inspections;
	}
    
     

}