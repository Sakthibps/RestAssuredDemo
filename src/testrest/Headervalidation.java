package testrest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Headervalidation {
@Test
public void validateHeader()
{
	RestAssured.baseURI ="https://reqres.in/api";
	RequestSpecification httpRequest = RestAssured.given();
	   Response response=httpRequest.get("/users");
	   String cty=response.getHeader("Content-Type");
	   String server=response.getHeader("Server");
	   System.out.println("Content-type:"+cty+"Server name"+server);
	   Assert.assertEquals(cty,"application/json");
	   Headers heads=response.headers();
	   for(Header headers1:heads)
	   {
		 System.out.println( headers1.getName()+": "+headers1.getValue());
	   }
	}
}
