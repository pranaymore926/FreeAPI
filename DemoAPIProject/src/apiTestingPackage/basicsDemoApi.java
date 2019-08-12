package apiTestingPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class basicsDemoApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
			param("location", "-33.8670522,151.1957362").
			param("radius","500").
			param("key","AIzaSyBSSq-ZEJJ8fhex_samjd4V8uRQgbGhnZM").
			when().
			get("maps/api/place/nearbysearch/json").
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].name",equalTo("Sydney"));
		System.out.println("ok");

	}

}
