package Projects;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class GitHubRestAssuredProjectTest {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIF3vJuvvBKSjfCjlkKrJKc6tcj7aWbeMsXkdBxrzXGd7";
	int sshKeyId=0;
	
	 @BeforeClass
	  public void setUP() {
		 //request specification
		  requestSpec= new RequestSpecBuilder().
				  setBaseUri("https://api.github.com/user/keys").
				  addHeader("Authorization", "token ").//removing access token to upload the code in github
				  addHeader("Content-Type", "application/json").
				  build();
		//Response specification
		  responseSpec= new ResponseSpecBuilder().
				  expectResponseTime(lessThanOrEqualTo(4000L)).
				  expectBody("key", equalTo(sshKey)).
				  expectBody("title", equalTo("TestAPIKey")).
				   build();
	 }  
		  @Test(priority=1)
		  public void postRequest() {
			  //https://api.github.com/users/keys
			  //request body
			  Map<String, Object> reqBody = new HashMap<>();
				reqBody.put("title", "TestAPIKey");
				reqBody.put("key", sshKey);
				//generate response
				Response response = given().spec(requestSpec)
						.body(reqBody).log().all()//add request body
						.when().post(); // Send POST request
				//extract the sshkeyId
				sshKeyId=response.then().extract().path("id");
				// Assertion
				response.then().spec(responseSpec).statusCode(201);
			  
		  }
		//GET ///https://api.github.com/user/keys/{keyId} 
		  @Test(priority=2)
		  public void getRequest() {
			  given().spec(requestSpec).pathParam("keyId", sshKeyId). when().get("/{keyId}").then().spec(responseSpec).statusCode(200);
			  
		  }
		//DELETE //https://api.github.com/user/keys{petId}
		  @Test(priority=3)
		  public void deleteRequest() {
		  	 given().spec(requestSpec).pathParam("keyId", sshKeyId).when().delete("/{keyId}"). then().statusCode(204);
		  	
		  }
	 
}

 
  