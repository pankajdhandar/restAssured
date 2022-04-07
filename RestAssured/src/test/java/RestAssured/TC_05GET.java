package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;

public class TC_05GET {
	@Test
	void googleMapTest()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpreq=RestAssured.given();
		
	//	Response response=httpreq.request(Method.POST,"/users");
			JSONObject reqpara=new JSONObject();
			reqpara.put("name","pankaj");
			reqpara.put("job","leader");
			httpreq.header("content-Type","application/json; charset=utf-8");
			httpreq.body(reqpara.toJSONString());
		Response response=httpreq.request(Method.POST,"/users");
		String responseBody=response.getBody().asString();
		System.out.println("Response body is "+responseBody);
		
		//status code valdation
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+ statuscode);
	Assert.assertEquals(statuscode, 201);
	
	// validate success code 
	String successCode=response.jsonPath().get("SuccessCode");
	System.out.println(successCode);
	
	}	
	
	

}
