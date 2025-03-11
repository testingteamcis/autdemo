package resources;

public enum GetRequestMethods {
	
	
	
	AddplaceApi("/maps/api/place/add/json"),
	GetplaceApi("/maps/api/place/get/json"),
	UpdateplaceAPi("/maps/api/place/update/json"),
	DeleteplaceApi("/maps/api/place/delete/json");


private String resources;

GetRequestMethods(String resources) {
	
	this.resources = resources;
}

public String getResoucres() {
	
	return resources;
}

}