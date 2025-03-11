package Oauthi;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import practice.WebAutomation;
import practice.api;
import practice.getcourses;

public class getAccessTokendemo {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Selenium Webdriver Java");
		a.add("Cypress1");
		a.add("Protractor");

		String response = 	given()
				.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParams("grant_type","client_credentials")
				.formParams("scope","trust")
				.when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
			
			System.out.println(response);
			JsonPath jsonPath = new JsonPath(response);
			String accessToken = jsonPath.getString("access_token");
			
			getcourses gc=	given()
					.queryParams("access_token", accessToken)
					.when().log().all()
					.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(getcourses.class);
				
			//	System.out.println(gc.getLinkedIn());
			//	System.out.println(gc.getInstructor());
				
				List<WebAutomation> mp=gc.getCourses().getWebAutomation();
				ArrayList<String> b = new ArrayList<String>();
				for(WebAutomation ch:mp) {
					
					//System.out.println(ch.getCourseTitle());
					
					b.add(ch.getCourseTitle());
					System.out.println("both are equal");

					
				}
				
				Assert.assertEquals(a,b);
					
					
				


	}

}
