package cabz.dto;

public enum CustomerType {
	
	PRIORITY("PRIORITY"),
	BASIC("BASIC");
	
	
		
	private String value;
	
	private CustomerType(String value){
		this.value=value;
		
	}

}
