package day2;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class Github {
  @Test(enabled=true)
  public void gettingAllRepositeries() {
	  given()
	  .auth()
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(200); 
  }
  
  @Test(enabled=true)
  public void createRepositeries() {
	  JSONObject data= new JSONObject();
	  data.put("name", "restAssuredCreations");
	  data.put("description", "I am created by restAssuredTool");
	  data.put("homepage","https://github.com/Saikat379");
	 
	  
	  given()
	  .auth()
	  .oauth2("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" )
	  .header("Content-Type", "application/json")
	  .body(data.toJSONString())
	  .when()
	  .post("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(201)
	  .time(Matchers.lessThan(8000L), TimeUnit.MILLISECONDS);
}
}