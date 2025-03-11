package resources;

import java.util.ArrayList;

import io.restassured.RestAssured;
import practice.AddplaceApidemo;
import practice.Locations;

public class TestData {
	
	
	public AddplaceApidemo AddPlaceApiPayload(String name, String language, String phonenumber) {
		
		AddplaceApidemo ApAd = new AddplaceApidemo();

		ApAd.setAccuracy(50);

		ApAd.setLanguage(language);

		ApAd.setName(name);

		ApAd.setPhone_number(phonenumber);

		ApAd.setWebsite("Vetcha.pavan@gmail.com");

		ApAd.setAddress("Chandanagar");

		ArrayList<String> As = new ArrayList<String>();

		As.add("shoe park");
		As.add("shop");

		ApAd.setTypes(As);

		Locations location = new Locations();

		location.setLat(-38.383494);
		location.setLng(33.427362);

		ApAd.setLocation(location);
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		return ApAd;

	}

	public String deletepayload(String placeid) {
		
		return "{\r\n\"place_id\":\""+placeid+"\"\r\n\r\n}";

		
	}
}
