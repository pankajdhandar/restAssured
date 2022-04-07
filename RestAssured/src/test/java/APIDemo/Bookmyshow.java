package APIDemo;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
public class Bookmyshow {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	driver.get("https://accounts.google.com/o/oauth2/auth/identifier?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fin.bookmyshow.com%3Fid%3Dauth405033&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&include_granted_scopes=true&client_id=990572338172-iibth2em4l86htv30eg1v44jia37fuo5.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fin.bookmyshow.com&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow");
	driver.findElement(By.cssSelector("input[type='email]")).sendKeys("testerpt7@gmail.com");
	driver.findElement(By.cssSelector("input[type='email]")).sendKeys(Keys.ENTER);
	driver.findElement(By.cssSelector("input[type='password]")).sendKeys("p@nkaj123");
	driver.findElement(By.cssSelector("input[type='password]")).sendKeys(Keys.ENTER);
	Thread.sleep(3000);
String url=driver.getCurrentUrl();


		
	String response=given().queryParam("","")
	.queryParam("redirect_uri","storagerelay%3A%2F%2Fhttps%2Fin.bookmyshow.com%3Fid%3Dauth405033")
	.queryParam("response_type","permission%20id_token")
	.queryParam("scope","email%20profile%20openid")
	.queryParam("client_id","990572338172-iibth2em4l86htv30eg1v44jia37fuo5.apps.googleusercontent.com")
.when().log().all()
.post("https://www.googleapis.com/oauth2/v4/token").asString();
	JsonPath js=new JsonPath(response);
	js.get(access_token)

		
	}
	
	
	

}
