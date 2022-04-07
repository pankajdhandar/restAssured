package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC003_Get {
@Test
void test_01() {
	Response response=get("https://reqres.in/api/users?page=2");
	JsonPath jsonpath=response.jsonPath();
	System.out.println(jsonpath.get("id"));
	System.out.println(jsonpath.get("email"));
	System.out.println(jsonpath.get("firstname"));
	Assert.assertEquals(jsonpath.get("id"),"7");
	Assert.assertEquals(jsonpath.get("firstname"),"Michael");
/*
	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println("content type:"+response.getContentType());
	System.out.println("status code:"+response.getStatusCode());
	System.out.println("status line:"+ response.getStatusLine());
	System.out.println("Header"+response.getHeader("content-type"));
	System.out.println("time"+response.getTime());
	int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode, 200);
	 Headers headerall=response.headers();
	 for (Header header:headerall) 
	 {
		 System.out.println(header.getName()+"    "+header.getValue());
	 }
	 */
}
}
/*
@Test
	void test_02() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id",equalTo(7));
		
	
	}
	
	
}
*/