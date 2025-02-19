package Projects;

//import org.testng.annotations.Test;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.AfterClass;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	//Set the headers
	Map<String,String> headers= new HashMap<>();
	//create the contract(Pact)
	@Pact(consumer = "UserConsumer",provider="UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider  builder) {
		//set the headers
		headers.put("Content-Type","application/json");
		//the request and response body
		DslPart reqResBody = new PactDslJsonBody().//Dsl-domain specific language
				numberType("id",144).//to get expected response we r passing values here
				stringType("firstName","Presilla").
				stringType("lastName","Redkar").
				stringType("email","presilla@gmail.com");
		
		//create the Pact or build the interactions /pre-defining request &response
		return builder.given("POST Request").
				uponReceiving("A request to craete a user")
				.method("POST")//here we wl create request
			    .path("/api/users")
			    .headers(headers)
			    .body(reqResBody)
			   // .pathFromProviderState("/{userId},"/90")
			    .willRespondWith()//here  we will create response
			    .status(201)
			    .body(reqResBody)
			    .toPact();//this will return to pact
	}
	
  
	//consumer test with mock provider
	//pact support only Junit not testng
	//use junit test
	@Test 
	@PactTestFor(providerName="UserProvider",port="8282")//we can take any port like 8080, 8181 etc
	public void postRequestTest() {
		//ctraete a request body
		Map<String,Object>reqBody= new HashMap<>();
		reqBody.put("id",144);
		reqBody.put("firstName","Presilla");
		reqBody.put("lastName","Redkar");
		reqBody.put("email","presilla@gmail.com");
		//send request,get response and add assertions
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all()
		.when().post()
		.then().statusCode(201).body("firstName", equalTo("Presilla")).log().all();
		
		
	}
	

}