package testrest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstRequest {
@Test
public void ta1()
{
	RestAssured.baseURI ="https://reqres.in/api";
	RequestSpecification httpRequest = RestAssured.given();
	   Response response=httpRequest.get("/users");
	   String responseBody = response.getBody().asString();
	   System.out.println("Response --"+responseBody);
	   int statuscode=response.getStatusCode();
	   Assert.assertEquals(statuscode, 200);
		
	
	}
}
