package RestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class JiraTest {
 public static void main(String[] args) {
	
	 RestAssured.baseURI="http://localhost:8080";
	 SessionFilter session=new SessionFilter();
	String response=given().header("Content-Type","application/json")
	.body("{ \"username\": \"pankajdhandar\", \"password\": \"p@nkaj123\" }").log().all().filter(session)
	.when()
	.post("/rest/auth/1/session")
	.then().log().all().extract().response().asString();
	
	String getcomment = given().queryParam("key","10004")//.header("Cookie","JSESSIONID=8AF35907C9563EF97DB028670510DA42")
	.body("{\"body\":\"Hey i have commented for rest API\",\r\n"
			+ " \"visibility\": {\r\n"
			+ "        \"type\": \"role\",\r\n"
			+ "        \"value\": \"Administrators\"\r\n"
			+ " }\r\n"
			+ "}").log().all().filter(session)
	.when().post("/rest/api/2/issue/{key}/comment")
	//.when().post("/rest/api/2/issue/10004/comment")
	.then().log().all().assertThat().statusCode(201).extract()
	.response().asString();
	JsonPath js=new JsonPath(getcomment);
	String commentid=js.getString("id");
	
	/*
	 given().header("X-Atlassian-Token","nocheck").filter(session).pathParam("key","10004").header("Content-Type","multipart/form-data")
	 .multiPart("file",new File("jira.txt"))
	 .when().post("rest/api/2/issue/{issue-key}/attachments").then().log().all().assertThat().statusCode(200);
	*/
	 String issuedetails=given().filter(session).pathParam("key","10004").log().all().when().get("/rest/api/2/issue/{key}")
	 .then().log().all().extract().response().asString();
	 System.out.println(issuedetails);
	 JsonPath js1=new JsonPath(issuedetails);
	int commentcount=js1.getInt("fields.comment.comment.size()");
			for (int i=0;i<commentcount;i++) {
		   String commentidissue=js1.get("fields.comment.comments["+i+"].id").toString();
		 if(commentidissue.equalsIgnoreCase(commentid))
		 {
			 String message=js1.getString("fields.comment.comments["+i+"].body").toString();
			 System.out.println(message);
			 //Assert.assertEquals(message, expectedmessage);
			// Assert.assertEquals(message,expectedmessage);
		 }
			}
			
			
}
	
	
}
