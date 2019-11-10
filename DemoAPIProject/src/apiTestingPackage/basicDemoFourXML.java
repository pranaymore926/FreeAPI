package apiTestingPackage;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import files.ReusuableMethods;

public class basicDemoFourXML 
{
	@Test
	public void postData() throws IOException
	{
		String postData = GenerateStringFromResource("C:\\Users\\Pranay\\Desktop\\API testing\\Body.xml");
		
		
	 RestAssured.baseURI = "http://216.10.245.166" ;
		// fetching the XML response as String 
		Response resp = given().
		queryParam("key", "qaclick123").body(postData).		
		when().post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().
		contentType(ContentType.XML).extract().response();
		
		XmlPath xml_Response = ReusuableMethods.rawToXML(resp);
		
		System.out.println("XML status code will be as follow "
				+xml_Response.getString("response.status"));

}
	
	//This utility willl convert the XML response into String 
	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String (Files.readAllBytes(Paths.get(path)));
		
	}

}
