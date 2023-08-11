package testrest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class putexample {
	@Test
	public void UserRegistrationSuccessful() 
	{ 
	    RestAssured.baseURI ="https://reqres.in/api"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	   // "email": "eve.holt@reqres.in",
	    //"password": "cityslicka"
	    requestParams.put("email", "eve.holt@reqres.in");
	    requestParams.put("password", "cityslicka"); 
	    request.body(requestParams.toJSONString());
	    Response response = request.post("/login"); 
	    ResponseBody body = response.getBody();
	    System.out.println(response.getStatusLine());
	    System.out.println(body.asString());
	     
	}
}
