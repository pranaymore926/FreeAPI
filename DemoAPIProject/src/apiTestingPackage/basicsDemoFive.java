package apiTestingPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import files.ReusuableMethods;
public class basicsDemoFive {

	@Test
	public void testOne()
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response resp = given().
			param("location", "-33.8670522,151.1957362").
			param("radius","1500").
			param("key","AIzaSyBSSq-ZEJJ8fhex_samjd4V8uRQgbGhnZM").log().all().
			when().
			get("maps/api/place/nearbysearch/json").
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].name",equalTo("Sydney")).and().body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
			and().header("Server", equalTo("scaffolding on HTTPServer2")).log().body()
			.extract().response();
		
		JsonPath js = ReusuableMethods.rawToJson(resp);
	
		//String str_json = resp.asString();
		//System.out.println(str_json);
		int count  = js.get("results.size()");
		
		for(int i=0; i<count ; i ++)
		{
			String name = js.get("results["+i+"].name");
			System.out.println(name);
		}
		System.out.println("Size of array response is = "+count);
	}

}
