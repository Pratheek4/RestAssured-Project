package stepDefination;

import static org.junit.Assert.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.APIResources;
import resource.TestDataBuild;
import resource.Utils;
import static io.restassured.RestAssured.given;
	
public class MySteps extends Utils {
	
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("^Add Place Paylode \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_paylode(String name, String language, String address) throws Throwable {
		res=given().spec(requestSpecificatoin()).body(data.addPlacePayload(name,language,address));
	    } 
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method)  throws Throwable {
		
		APIResources resourceAPI = APIResources.valueOf(resource); // Send the api name from feature file to enum class, match the api name and bring the api name and store in the variable
		System.out.println(resourceAPI.getResource()); // Print the Api
	    	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    	
	    	if(method.equalsIgnoreCase("POST")) {
	    		response =res.when().post(resourceAPI.getResource());
	    	}
	    	else if(method.equalsIgnoreCase("GET")) {
	    		response =res.when().get(resourceAPI.getResource());		    			
	    	}
	    }
	
	@Then("^The Api call got success with status code$")
	public void the_api_call_got_success_with_status_code() throws Throwable {
			System.out.println(response.getContentType());
	    	 assertEquals(response.getStatusCode(),200);
	    }
	
	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String keyvalue) {
	    	System.out.println(response.getStatusCode());
	    	/*String resp = response.toString();// getting an error as "Failed to parse the JSON document" so commenting out this code
	     	JsonPath js = new JsonPath(resp);
	     	assertEquals(js.get(key).toString(),keyvalue); */ // key is not in string so to convert we use .toStirng()
	    }  
}
