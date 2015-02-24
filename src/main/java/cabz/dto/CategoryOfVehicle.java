package cabz.dto;

public enum CategoryOfVehicle {
	
	SEDAN("SEDAN"),
	PREMIUM_SEDAN("PREMIUM_SEDAN"),
	HATCHBACK("HATCHBACK"),
	TEMPO_TRAVELLER("TEMPO_TRAVELLER"),
	BUS("BUS"),
	SUV("SUV");
	
	private String value;
	
	private CategoryOfVehicle(String value){
		this.value=value;
		
	}

}
