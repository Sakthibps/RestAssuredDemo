package testrest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Jsonresponse {

	@Test
	public void VerifyCityInJsonResponse()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("id","2").get("/users");
          String resp=response.getBody().asString();
          System.out.println(resp);
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = new JsonPath(resp);

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String id = jsonPathEvaluator.getString("data/id");

		// Let us print the city variable to see what we got
		System.out.println("id received from Response " + id);

		// Validate the response
		Assert.assertEquals(id,"2", "Correct id name received in the Response");

	}	
}

