package cabz.dto;

public enum ClassOfRide {
	
	STANDARD("STANDARD"),
	PREMIUM("PREMIUM"),
	BUSINESS("BUSINESS"),
	FAMILY("FAMILY");
	
		
	private String value;
	
	private ClassOfRide(String value){
		this.value=value;
		
	}

}
