package cabz.dto;

public class Deal {
	private String id;

	private String originTripId;

	private long dealTime;

	private String source;

	private String destination;

	private String vehicleRegistrationNo;

	private String driverId;

	private boolean isDeleted;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginTripId() {
		return originTripId;
	}

	public void setOriginTripId(String originTripId) {
		this.originTripId = originTripId;
	}

	public long getDealTime() {
		return dealTime;
	}

	public void setDealTime(long dealTime) {
		this.dealTime = dealTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	private long lastUpdated;
}
