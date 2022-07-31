package resource;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;

public class TestDataBuild {

	
	public AddPlace addPlacePayload(String name, String language, String address) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		 AddPlace p =new AddPlace();
		 p.setAccuracy(50);
		 p.setName(name);
		 p.setAddress(address);
		 p.setLangauge(language);
		 p.setPhone_number("(+91) 983 893 3937");
		 p.setWebsite("https://rahulshettyacademy.com");
		 List<String> myList =new ArrayList<String>();
		 myList.add("shoe park");
		 myList.add("shop");
		 p.setType(myList);
		 Location l =new Location();
		 l.setLat(-38.383494);
		 l.setLan(33.427362);
		 p.setLocation(l);
		 return p;
	}

}
