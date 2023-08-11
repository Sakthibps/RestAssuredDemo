package testrest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class queryparam {
@Test
public void ParamExample()
{
	RestAssured.baseURI ="https://reqres.in/api";
   RequestSpecification httpRequest = RestAssured.given();
Response response=httpRequest.queryParam("first_name","Janet").get("/users");
String jsonstring=response.asString();
System.out.println(jsonstring);
Assert.assertEquals(jsonstring.contains("Janet"),true);
	}
}
