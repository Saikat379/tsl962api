package day2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class NegativeContactList {
  @Test(enabled=false)
  public void recordNotFound() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts/5")
	  .then()
	  .log()
	  .body()
	  .statusCode(404);
  }
  
  @Test(enabled=false, description="adding contact with missing details")
  public void addingContactMissing() {
	  JSONObject details = new JSONObject();
	  JSONObject location = new JSONObject();
	  JSONObject emp = new JSONObject();
	  
	  location.put("city", "Kolkata");
	  location.put("country", "India");
	  
	  emp.put("jobTitle", "AT");
	  emp.put("company", "LTI");
	  
	  details.put("firstName", null);
	  details.put("lastName", "Roy");
	  details.put("email", "rsaikat978@gmail.com");
	  details.put("location", location);
	  details.put("employer", emp);
	  
	  
	  String error = given()
	  .header("Content-Type", "application/json")
	  .body(details.toJSONString())
	  .when()
	  .post("http://3.13.86.142:3000/contacts")
	  .then()
	  .log()
	  .body()
	  .statusCode(400)
	  .extract()
	  .path("err");
	  
	  Assert.assertTrue(error.contains("firstName: First Name is required"));
  }
  
  @Test(enabled=true, description="adding contact with too many character")
  public void addingContactBigSize() {
	  JSONObject details = new JSONObject();
	  JSONObject location = new JSONObject();
	  JSONObject emp = new JSONObject();
	  
	  location.put("city", "koooooooooooooooooooooooolkaaaaaaaaaaaaaaaaaaaaaataaaaaaaaaaaaaaaaaaaaaaaaa");
location.put("country", "India");
	  
	  emp.put("jobTitle", "AT");
	  emp.put("company", "LTI");
	  
	  details.put("firstName", null);
	  details.put("lastName", "Roy");
	  details.put("email", "rsaikat978@gmail.com");
	  details.put("location", location);
	  details.put("employer", emp);
	  
	  
	  String error = given()
	  .header("Content-Type", "application/json")
	  .body(details.toJSONString())
	  .when()
	  .post("http://3.13.86.142:3000/contacts")
	  .then()
	  .log()
	  .body()
	  .statusCode(400)
	  .extract()
	  .path("err");

	  Assert.assertTrue(error.contains("is longer than the maximum allowed length (30)"));
  }
  
  @Test(enabled=true,description="Invalid email character")
  public void invalidemailcharacter() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  loc.put("city", "Kolkata");
  loc.put("country", "India");
  emp.put("JobTitle", "AT");
  emp.put("company", "LTI");
  details.put("firstName", "Saikat");
  details.put("lastName","Roy");
  details.put("email", "rsaikat978@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
	 
	 Assert.assertTrue(error.contains("Validator failed for path `email` with value"));

	 
  }
  @Test(enabled=true,description="Invalid email character")
  public void invalidName() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  loc.put("city", "Kolkata");
  loc.put("country", "India");
  emp.put("JobTitle", "AT");
  emp.put("company", "LTI");
  details.put("firstName", "Soku456");
  details.put("lastName","Roy");
  details.put("email", "rsaikat978@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
	 
	 Assert.assertTrue(error.contains("Validator failed for path `firstName` with value `Soku456`"));

	 
  }
}