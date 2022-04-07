package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import files.payload;
public class TC006 {
	public static void main(String[] args) {
		
	
JsonPath js=new JsonPath(payload.courseprice());
int count=js.getInt("courses.size()");
System.out.println(count);
//print purchas amount 
int totalamount=js.getInt("dashboard.purchaseAmount");
System.out.println(totalamount);
String title=js.get("courses[0].title");
System.out.println(title );

for (int i=0;i<count;i++) {
	String cursetitle=js.get("courses["+i+"].title");
	System.out.println(js.get("courses["+i+"].price").toString());
	System.out.println(cursetitle);
}


	}
	
	
	
}
