package RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_04 {
@Test
void test04() {
	// given().get("https://reqres.in/api/users?page=2").then().statusCode(200).bo, null)
	given().get("https://reqres.in/api/users?page=2").then()
	.statusCode(200)
	.body("data.id", equalTo(7));
	
	
	
	
	
	
}
	
	
	
}
