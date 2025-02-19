package Examples;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

//static import -->below 2 are static imports
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
  @Test
  public void getRequestWithQueryParam() {
	  //create a response object
	  Response response= 
			given().//request specification
			  baseUri("https://petstore.swagger.io/v2/pet").
			  header("Content-Type","application/json").//to ensure our header passed correctly and read it as json otherwise it wl read as plain text
			  queryParam("status","alive").
			  //above are basic for every query parameters to send the request
			when().//send the request and receive response
			   get("/findByStatus");//here we wl specify methods ans specify the path
	 
	  //print the status code
	  System.out.println(response.getStatusCode());
	  
	  //print the response body
	  System.out.println(response.getBody().asString());//this wl written everything in oneline
	  System.out.println(response.getBody().asPrettyString());//easy read to  json 
	  
	  //print the response header
	  System.out.println(response.getHeaders().asList());
	  //to assert the  indivials property like name , status from the response
	  String petStatus= response.then().extract().path("[0].status");
	  assertEquals(petStatus,"alive");
	  //above is testNG assertion
	  
	  //print and assert the pet status using RESTAsured assertion
	  response.then().statusCode(200).body("[0].status", equalTo("alive"));
	  
  }
  //GET https://petstore.swagger.io/v2/pet/{petId}
  @Test
  public void getRequestWithPathParam() {
	 //send request,receive resonse and perform assertions
	given().//request specification
	  baseUri("https://petstore.swagger.io/v2/pet").
	  header("Content-Type","application/json").
	  pathParam("petId",77232).
	  log().all().//URI,HTTP method,headers,body,parameters,proxy,
	when().
		get("/{petId}"). //here should match with exact name given in pathParam
	then().
	   statusCode(200).
	   body("name",equalTo("Hansel")).
	   log().all();//wl get body, status,headers
  }
  
  }
  