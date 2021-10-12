package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherAPI {
  @Test(description="Getting weather information of specific city")
  public void getWeather() {
	  RestAssured.given()		// Some Pre-condition like Authentication
	  .when()					// Performs some steps
	  .get("https://api.openweathermap.org/data/2.5/weather?q=kolkata&appid=f4959247acf5d4b973271bc14839636b")
	  .then()			// Some Post_Condition like Verification
	  .log()			//Print data in Console
	  .body()
	  .statusCode(200);
	  
  }
  @Test(description="Getting weather information of specific city")
  public void getWeather2() {
	Response res=  RestAssured.given()		// Some Pre-condition like Authentication
	  .when()					// Performs some steps
	  .get("https://api.openweathermap.org/data/2.5/weather?q=kolkata&appid=f4959247acf5d4b973271bc14839636b");
	//  .then()			// Some Post_Condition like Verification
	//  .log()			//Print data in Console
	//  .body()
	//  .statusCode(200);
	  
	System.out.println(res.prettyPrint());
	System.out.println(res.getTime());
	System.out.println(res.getStatusCode());
	System.out.println(res.getContentType());
	
	  
  }
}