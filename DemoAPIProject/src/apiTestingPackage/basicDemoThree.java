package apiTestingPackage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import files.Resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import files.PayLoad;


import javax.annotation.Resource;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class basicDemoThree 
{
	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Pranay\\git\\FreeAPI\\DemoAPIProject\\src\\files\\env.properties");
		
		prop.load(fis);
		
	}
	@Test
	public void addAndDelete()
	{
		
RestAssured.baseURI = prop.getProperty("HOST"); ;
		
//Grab the response 
		Response res = given().
		queryParam("key", prop.getProperty("KEY")).
		body(PayLoad.postData()).
		when().post(Resources.placePostData()).
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().body("status", equalTo("OK"))
		.extract().response();
		
		String responseString = res.asString();
		System.out.println(responseString);
		
		
		// grab the place ID from response 
		
		JsonPath js = new JsonPath(responseString);
		String placeId = js.get("place_id");
		System.out.println("Place ID = "+placeId);
		
		String placeIdBody ="{\r\n" + 
				"    \"place_id\":\"placeId\"           \r\n" + 
				"}\r\n" + 
				"" ;
		given().
		queryParam("key", "qaclick123").
		body(placeIdBody).when().post("/maps/api/place/delete/json").then().assertThat().statusCode(404).and().
		contentType(ContentType.JSON).and().body("status", equalTo("OK"));
		
		
	}

}
