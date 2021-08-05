package resources;

public enum ApiResources {
	
	
	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("maps/api/place/delete/json"),
	GetPlaceApI("maps/api/place/get/json");
	private String resources;

	ApiResources(String resources) {
		// TODO Auto-generated constructor stub
		this.resources=resources;
	}
	
	

	public String getresources()
	{
		return resources;
	
	}
	
}
