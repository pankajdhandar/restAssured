package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get {

	@Test 
	void weatherdetails() {
		/*//specify Base URI  
		RestAssured.baseURI="https://openweathermap.org/find?q=pune";
		//Request object 
		RequestSpecification httprequest=RestAssured.given();		
		//create response object 
		Response res=httprequest.request(Method.GET,"/pune");
		String responsebody=res.getBody().asString();
		System.out.println("Response body is :"+ responsebody);
		*/
		
		/*
		   //Specify base URI
		  RestAssured.baseURI="https://reqres.in/api/users?page=2";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"2");
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  */
		 RestAssured.baseURI="https://reqres.in/api/users/23";
		 RequestSpecification httpreq=RestAssured.given();
		 Response response=httpreq.request(Method.GET,"23");
		 
		 //print reponse in console window 
		 String responseBody=response.getBody().asString();
	System.out.println("Response Body is:"+ responseBody);
	//Status code validation 
	int statuscode=response.getStatusCode();
	System.out.println("Status code is :"+ statuscode);
	Assert.assertEquals(statuscode, 200);
	
		
	}
	
	
	
	
	
}
