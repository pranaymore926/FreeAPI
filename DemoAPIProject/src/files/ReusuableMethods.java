package files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusuableMethods 
{
	public static XmlPath rawToXML(Response resp)
	{
		String strResponse = resp.asString();	
		XmlPath xml_Response = new XmlPath(strResponse);
		 return xml_Response;

	}

	public static JsonPath rawToJson(Response resp)
	{
		String strResponse = resp.asString();	
		JsonPath json_Response = new JsonPath(strResponse);
		 return json_Response;

	}
}
