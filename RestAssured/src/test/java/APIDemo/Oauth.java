package APIDemo;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;
public class Oauth {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php\"");
		driver.findElement(By.cssSelector("input[type='email']"));
		
		
		
		String accessToken=given().queryParam("code","")
		.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type","authorization_code")
		.when()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js=new JsonPath(accessToken);
		String accesstoken=js.get("access_token");
		
		
		
		String response =given().queryParam("access_token", accesstoken)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
	}

}
