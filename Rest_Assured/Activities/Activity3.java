package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
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


public class Activity3 {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
 
 
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
			  expectContentType("application/json").
			  expectBody("status", equalTo("alive")).
			  expectResponseTime(lessThanOrEqualTo(3000L)).
			  
			  build();
	  
	  
  }
  @DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};
		return testData;
	}
  

 //POST request on https://petstore.swagger.io/v2/pet
  @Test(priority=1,dataProvider = "petInfo")
  public void postRequest(int petId, String petName, String petStatus) {
	  //create response body
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);

		Response response = given().spec(requestSpec)
			.body(reqBody)//add request body
		.when().post(); // Send POST request
		
		//extract the petId
		//petId=response.then().extract().path("id");

		// Assertion
		response.then().spec(responseSpec).body("name", equalTo("petName"));
  }
   //GET https://petstore.swagger.io/v2/pet/{petId}
  @Test(priority=2,dataProvider = "petInfo")
  public void getRequest(int petId, String petName, String petStatus) {
	  given().spec(requestSpec).pathParam("petId", petId).
	  log().all().
	  when().get("/{petId}").
	  then().spec(responseSpec).body("name", equalTo(petName)).log().all();
	  
  }
   //DELETE https://petstore.swagger.io/v2/pet/{petId}
@Test(priority=3,dataProvider = "petInfo")
public void deleteRequest(int petId, String petName, String petStatus) {
	 given().spec(requestSpec).pathParam("petId", petId).
	  when().delete("/{petId}").
	  then().body("code",equalTo(200)).body("message", equalTo("" +petId));
	
}

}