package apiTestingPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
public class basicsDemoTwo 
{
	@Test
	public void postData()
	{
		RestAssured.baseURI = "http://216.10.245.166/" ;
		
		given().
		queryParam("key", "qaclick123").
		body("{\r\n" + 
				"    \\\"place_id\\\":\\\"5bd6898ac4da7b05e89e49f4f20e67d0\\\"           \r\n" + 
				"}").
		when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
		

}
}