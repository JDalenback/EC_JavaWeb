package model;

public class weatherBean {
	
	private static final weatherBean instance = new weatherBean();
	
	private String date;

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	private Double AvgTemperature;

	
	public weatherBean() {}
	
	public static weatherBean getInstance() {
		return instance;
	}
	
	
	public String getDate() {
		return date;
	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}
	
	public Double getAvgTemperature() {
		return AvgTemperature;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setCityStr(String city) {
		cityStr = city;
	}
	
	public void setCountryStr(String country) {
		countryStr = country;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
	
	
	public void setAvgTemperature(Double temperature) {
		AvgTemperature = temperature;
	}
		
		
		
		
		
		
		
		
		
		
		
		

}
