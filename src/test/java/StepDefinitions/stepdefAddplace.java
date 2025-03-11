package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.GetRequestMethods;
import resources.TestData;
import resources.Utils;

public class stepdefAddplace extends Utils{
	
	TestData td = new TestData();

	RequestSpecification req;

	RequestSpecification req1;

	ResponseSpecification resp;
	
	static String placeid;
	
	Response res;
	@Given("Validate Add place API payload name {string} languauge {string} and phonenumber {string}")
	
	public void validate_add_place_api_payload_name_languauge_and_phonenumber(String name , String language, String phonenumber) throws IOException {
		req1 = given().spec(RequiredSpecciication()).body(td.AddPlaceApiPayload(name,language,phonenumber));

	}


	
	@When("user call  {string} using {string} http request method")
	public Response user_call_using_http_request_method(String resource, String method) {
		
		GetRequestMethods grm =GetRequestMethods.valueOf(resource);
		
		if(method.equalsIgnoreCase("POST")) {
		
		 res = req1.when().post(grm.getResoucres());
		 
		}
		else if(method.equalsIgnoreCase("GET")) {
			
			 res = req1.when().get(grm.getResoucres());
			 
			}
		else if(method.equalsIgnoreCase("Delete")) {
			
			 res = req1.when().get(grm.getResoucres());
			 
			}
		return res;

	}

	@Then("validate Api call is success status code is {int}")
	
	public void validate_api_call_is_success_status_code_is(Integer int1) {
		System.out.println(res.statusCode());
		Assert.assertEquals(res.statusCode(),200);
		
	}

	@Then("{string} code is {string}")
	public void code_is(String key, String value) {
		
		String Actualvalue=getJsonPath(res,key);
		
		System.out.println(Actualvalue);

		Assert.assertEquals(Actualvalue, value);
	}
	
	@Then("Validate the name {string} should match with getresponse {string} with using {string} https request method")
	
	public void validate_the_name_should_match_with_getresponse_with_using_https_request_method(String name, String resource, String method) throws IOException {
		
		placeid =getJsonPath(res,"place_id");
		System.out.println(placeid);

		
		req1 = given().spec(RequiredSpecciication()).queryParam("place_id", placeid);
		
		Response rese=user_call_using_http_request_method(resource, method);
		String Actualname =getJsonPath(rese,"name");
		Assert.assertEquals(name, Actualname);
		

	}
	@Given("get the delete payload")
	public void get_the_delete_payload() throws IOException {
		
		req1 = given().spec(RequiredSpecciication()).body(td.deletepayload(placeid));
		

		
	}


		
	   	}



