package cabz.dto;

import cabz.constants.ServiceCategory;

public class Booking {
	private String   id;

    private String   userId;

    private long   	 startTime;

    private long     bookingTime;

    private String   sourceLatitude;
    
    private String   sourceLongitude;
    
    private String   destinationLatitude;
    
    private String   destinationLongitude;
    
    private String 	  travellerName;
    
    private String 	  travellerMobile;
    
    private ServiceCategory category;
    
    private String pickupLocality;
    
    private String pickupAddress;
    
    private String dropLocality;

    private String dropAddress;
    
    private int noOfCustomers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(long bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getSourceLatitude() {
		return sourceLatitude;
	}

	public void setSourceLatitude(String sourceLatitude) {
		this.sourceLatitude = sourceLatitude;
	}

	public String getSourceLongitude() {
		return sourceLongitude;
	}

	public void setSourceLongitude(String sourceLongitude) {
		this.sourceLongitude = sourceLongitude;
	}

	public String getDestinationLatitude() {
		return destinationLatitude;
	}

	public void setDestinationLatitude(String destinationLatitude) {
		this.destinationLatitude = destinationLatitude;
	}

	public String getDestinationLongitude() {
		return destinationLongitude;
	}

	public void setDestinationLongitude(String destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}

	public String getTravellerName() {
		return travellerName;
	}

	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}

	public String getTravellerMobile() {
		return travellerMobile;
	}

	public void setTravellerMobile(String travellerMobile) {
		this.travellerMobile = travellerMobile;
	}

	public ServiceCategory getCategory() {
		return category;
	}

	public void setCategory(ServiceCategory category) {
		this.category = category;
	}

	public String getPickupLocality() {
		return pickupLocality;
	}

	public void setPickupLocality(String pickupLocality) {
		this.pickupLocality = pickupLocality;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDropLocality() {
		return dropLocality;
	}

	public void setDropLocality(String dropLocality) {
		this.dropLocality = dropLocality;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public int getNoOfCustomers() {
		return noOfCustomers;
	}

	public void setNoOfCustomers(int noOfCustomers) {
		this.noOfCustomers = noOfCustomers;
	}
    

}
