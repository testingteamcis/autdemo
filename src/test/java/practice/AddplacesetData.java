package practice;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class AddplacesetData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddplaceApidemo ApAd = new AddplaceApidemo();
		
		ApAd.setAccuracy(50);
		
		ApAd.setLanguage("Hindi");
		
		ApAd.setName("Pavan");
		
		ApAd.setPhone_number("9533745789");
		
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
		RestAssured.baseURI= "https://rahulshettyacademy.com";

		RequestSpecification req=new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key","qaclick123").build();
		
		ResponseSpecification resp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification req1=given().spec(req)
		.body(ApAd);
		Response res=req1.when().post("/maps/api/place/add/json")
		.then().log().all().spec(resp).extract().response();
		
		String res1=res.asString();
		
		System.out.println(res1);

	}

}
