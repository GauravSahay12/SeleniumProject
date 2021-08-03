package StepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@RunWith(Cucumber.class)
public class stepDefination {
	

	RequestSpecification  Spec_Request;
	RequestSpecification  Request1;
	ResponseSpecification Spec_Response;
	ResponseSpecification Res;
	
	
	Response Response1;


@Given("For the given request payload")
public void for_the_given_request_payload() {
    // Write code here that turns the phrase above into concrete actions
	
    pojo.Add_PogoMain_serialize ap =new pojo.Add_PogoMain_serialize();
  	
  	ap.setAccuracy(50);
  	ap.setName("Gaurav");
  	ap.setAddress("Mithapur");
  	ap.setLanguage("English");
  	ap.setPhone_number("91-8976544435");
  	ap.setWebsite("Google_com");
  	
  	List<String> mylist=new ArrayList<String>();
  	mylist.add("Shoe park");
  	mylist.add("Shop");
      ap.setTypes(mylist);
      
      pojo.Location l=new pojo.Location();
      l.setLat(-38.383494);
      l.setLng(33.427362);
      ap.setLocation(l);
     
       Spec_Request =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
      .setContentType(ContentType.JSON).build();
  	
       Request1 =given().spec(Spec_Request)
  		                .body(ap); 
	

}
@When("method is post and necessary url is provided")
public void method_is_post_and_necessary_url_is_provided() {
    // Write code here that turns the phrase above into concrete actions
	Res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	  
	  
	 Response1  = Request1.when().post("https://rahulshettyacademy.com/maps/api/place/add/json")
	                    .then().spec(Res).extract().response();
	
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



	
	




