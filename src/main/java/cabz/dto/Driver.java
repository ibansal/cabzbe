package cabz.dto;

public class Driver extends User{
	private String vendorEmail;
	
	private String verificationAdminId;
	
	private String policeVerificationFilePath;
	
	private IdentityProof drivingLicence;
	
	private int yearsOfExperiance;

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorId) {
		this.vendorEmail = vendorId;
	}

	public String getVerificationAdminId() {
		return verificationAdminId;
	}

	public void setVerificationAdminId(String verificationAdminId) {
		this.verificationAdminId = verificationAdminId;
	}

	public String getPoliceVerificationFilePath() {
		return policeVerificationFilePath;
	}

	public void setPoliceVerificationFilePath(String policeVerificationFilePath) {
		this.policeVerificationFilePath = policeVerificationFilePath;
	}

	public IdentityProof getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(IdentityProof drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public int getYearsOfExperiance() {
		return yearsOfExperiance;
	}

	public void setYearsOfExperiance(int yearsOfExperiance) {
		this.yearsOfExperiance = yearsOfExperiance;
	}
	
}
