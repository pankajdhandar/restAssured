package RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002Post {
@Test 
void registration() {
RestAssured.baseURI="https://reqres.in/api/users";
RequestSpecification httpReq=RestAssured.given();

//Response reponse=httpReq.request(Method.POST, null)
//Request payload sending using Post request
JSONObject rp=new JSONObject();
rp.put("name","pankaj");
rp.put("job", "leader");
httpReq.header("content-type","application/json; charset=utf-8");
httpReq.body(rp.toJSONString());
Response response=httpReq.request(Method.POST,"/users");
//Print reposne in console window
String responseBody= response.getBody().toString();

System.out.println("Response Body is :"+responseBody);
	
//Status code validation 
int statuscode=response.getStatusCode();
System.out.println("Status code is :"+statuscode);
Assert.assertEquals(statuscode,201);

//Sucess code validation 
String successcode=response.jsonPath().get("SuccessCode");
System.out.println(successcode);
//Assert.assertEquals(successcode,"OPERATION_SUCCESS");

	
}
	
	
	
	
	
	
}
