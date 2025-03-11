package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	static RequestSpecification req;
	
	ResponseSpecification resp;
	
	public RequestSpecification RequiredSpecciication() throws IOException {
		
		
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setBaseUri(getGlobalProperties("BaseURl"))
				.addQueryParam("key", "qaclick123").build();
		
		return req;
		}
		return req;

	}

	public ResponseSpecification ResponseSpecciication() {
		
		return resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}
	public static String getGlobalProperties(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Global.properties");

		
		//FileInputStream fis = new FileInputStream("C:\\Users\\VPAVAN\\ec1\\Bdd2\\src\\test\\java\\Global.properties");
		
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response path,String key) {
		
		String response=path.asString();

		JsonPath js = new JsonPath(response);
		
		return js.get(key).toString();
	}
}
