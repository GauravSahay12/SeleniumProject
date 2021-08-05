package StepDefinations;



import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(Cucumber.class)
public class stepDefination extends Utils{
	
	ResponseSpecification Res;
	RequestSpecification  Request1;
	
	Response Response1;
TestDataBuild TDB=new TestDataBuild();

@Given("For the given request payload {string} {string} {string}")
public void for_the_given_request_payload(String name , String language, String address) throws IOException {
    // Write code here that turns the phrase above into concrete actions

       Request1 =given().spec(RequestSpecification())
  		                .body(TDB.AddPlacePayload(name, address, language)); 
	
}
@When("User calls {string} with {string} http request")
public void method_is_post_and_necessary_url_is_provided(String resources,String method){
    
	//Here constructor will be called with value of resourse which you pass
	
	ApiResources ResourcesAPI=ApiResources.valueOf(resources);//invoke constructor with value of AddPlaceAPI
	  //ResourcesAPI.getresources();//gives the path of resourses
	
	if(method.equalsIgnoreCase("POST")) 
	{
	 Response1  = Request1.when().post(ResourcesAPI.getresources())
	                    .then().spec(ResponseSpecification()).extract().response();
	}
	
	else if(method.equalsIgnoreCase("GET"))
	{
		Response Response1   = Request1.when().get(ResourcesAPI.getresources())
                 .then().spec(ResponseSpecification()).extract().response();
	}
		
}

@Then("API call got success with status code {string}")
public void API_call_got_success_with_status_code(String code) {
    // Write code here that turns the phrase above into concrete actions
  assertEquals(Response1.getStatusCode(),Integer.parseInt(code));
  System.out.println("Successful");
}

   @Then("{string} in Response should generate with value {string}")
   public void in_response_should_generate_with_value(String key, String value) {
       // Write code here that turns the phrase above into concrete actions
	   String resp=Response1.asString();
	   JsonPath jp=new JsonPath(resp);
	 
	   assertEquals(jp.getString(key),value);
   }

}



	
	




