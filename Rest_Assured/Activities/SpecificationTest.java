package Examples;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

public class SpecificationTest {
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId=0;
  
  @BeforeClass
  public void setUP() {
	  //request specification
	  requestSpec= new RequestSpecBuilder().
			  setBaseUri("https://petstore.swagger.io/v2/pet").
			  addHeader("Content-Type", "application/json").
			  build();
	  //Response specification
	  responseSpec= new ResponseSpecBuilder().
			  expectStatusCode(200).
			 // expectBody("status", equalTo("alive")).
			  expectResponseTime(lessThanOrEqualTo(3000L)).
			  
			  build();
	  
	  
  }
//POST/https://petstore.swagger.io/v2/pet
  
  @Test(priority=1)
  public void postRequest() {
	  //create response body
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77232);
		reqBody.put("name", "Riley");
		reqBody.put("status", "alive");

		Response response = given().spec(requestSpec)
			.body(reqBody)//add request body
		.when().post(); // Send POST request
		
		//extract the petId
		petId=response.then().extract().path("id");

		// Assertion
		response.then().spec(responseSpec).body("status", equalTo("alive"));
  }
   //GET https://petstore.swagger.io/v2/pet/{petId}
  @Test(priority=2)
  public void getRequest() {
	  given().spec(requestSpec).pathParam("petId", petId).
	  when().get("/{petId}").
	  then().spec(responseSpec).body("status", equalTo("alive"));
	  
  }
   //GET https://petstore.swagger.io/v2/pet/{petId}
@Test(priority=3)
public void deleteRequest() {
	 given().spec(requestSpec).pathParam("petId", petId).
	  when().delete("/{petId}").
	  then().spec(responseSpec).body("message", equalTo("" +petId));
	
}
}