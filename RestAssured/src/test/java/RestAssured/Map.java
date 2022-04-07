package RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Map {
	public static void main(String[] args) {
		
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	Addplace p=new Addplace();
	p.setAccuracy(50);
	p.setAddress("29, side layout, cohen 09");
	p.setLanguage("French-IN");
p.setPhone_number("(+91) 983 893 3937");
p.setWebsite("https://rahulshettyacademy.com");
p.setName("Frontline house");

List<String> mylist=new ArrayList<String>();
mylist.add("shoe park");
mylist.add("shop");
p.setTypes(mylist);

Location l=new Location();
l.setLat(-38.383494);
l.setLng(33.427362);
p.setlocation(l);

RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
.setContentType(ContentType.JSON).build();


ResponseSpecification resspec=new RequestSpecBuilder().expectStatusCode().expectContentType(ContentType.JSON).build()
RequestSpecification res= given().spec(req)
	//Response  res =given().queryParam("key","qaclick123")
.body(p);

Response response=res.when().post("/maps/api/place/add/json").spec(resspec)
//.then().assertThat().statusCode(200)
	.extract().response();

		String response=res.asString();
		System.out.println(response);
		
		
		
		
		
	}
	
	
	

}
