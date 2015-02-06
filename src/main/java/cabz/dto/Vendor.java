package cabz.dto;

import java.util.Map;

import cabz.constants.ServiceCategory;

public class Vendor extends User{

	private String serviceTaxNo;
	
	private Map<ServiceCategory, Integer> cabInventory;
	
	private Map<String,String> phoneNo;
	
	private String firmName;
	
	private String firmAddress;
	
	private String tinNo;
	
	private String registrationNo;

	
}
