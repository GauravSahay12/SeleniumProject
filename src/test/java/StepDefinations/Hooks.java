package StepDefinations;
import io.cucumber.java.Before;
import java.io.IOException;

public class Hooks {
	

@Before("@DeleteRestApi")
	public void beforeScenario() throws IOException {
	
	stepDefination ad=new stepDefination();
	ad.for_the_given_request_payload("Gaurav","Hello", "Sahay");
	ad.method_is_post_and_necessary_url_is_provided("AddPlaceAPI","POST");
	ad.verify_place_id_created_maps_to_using("Gaurav","GetPlaceApI");
	}
}
