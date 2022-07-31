package resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecificatoin() throws IOException {
		
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt")); 
		req =new RequestSpecBuilder().setBaseUri(getGlobalValue("BaseUrl"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)) //for logging Request
				.addFilter(ResponseLoggingFilter.logResponseTo(log)) // for logging Response 
				.setContentType(ContentType.JSON).build(); 
		return req;
		}
		return req;
	}
	
	
	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/woovly/Desktop/Automation/RestAssured/APIFramwork/src/test/java/resource/global.properties");
		prop.load(fis);
		return prop.getProperty(key); 
	}
	
	public String getJsonPath (Response response, String key) {
		
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
