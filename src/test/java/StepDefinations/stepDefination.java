package StepDefinations;



import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(Cucumber.class)
public class stepDefination extends Utils{
	
	ResponseSpecification Res;
	RequestSpecification  Request1;
	
	Response Response1;
TestDataBuild TDB=new TestDataBuild();

@Given("For the given request payload")
public void for_the_given_request_payload() throws FileNotFoundException {
    // Write code here that turns the phrase above into concrete actions

       Request1 =given().spec(RequestSpecification())
  		                .body(TDB.AddPlacePayload()); 
	
}
@When("method is post and necessary url is provided")
public void method_is_post_and_necessary_url_is_provided() {
    // Write code here that turns the phrase above into concrete actions
	
	  
	 Response1  = Request1.when().post("https://rahulshettyacademy.com/maps/api/place/add/json")
	                    .then().spec(ResponseSpecification()).extract().response();
	
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



	
	




