package apiTestingPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
public class basicsDemoApi {

	@Test
	public void testOne()
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
			param("location", "-33.8670522,151.1957362").
			param("radius","1500").
			param("key","AIzaSyBSSq-ZEJJ8fhex_samjd4V8uRQgbGhnZM").
			when().
			get("maps/api/place/nearbysearch/json").
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].name",equalTo("Sydney")).and().body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
			and().header("Server", equalTo("scaffolding on HTTPServer2"));
		

	}

}
