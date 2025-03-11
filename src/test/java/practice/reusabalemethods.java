package practice;

import io.restassured.path.json.JsonPath;

public class reusabalemethods {
	
	public static  JsonPath getjsonpathclas(String responsename) {
		
		JsonPath js1 = new JsonPath(responsename);
		
		return js1;
	}

}
