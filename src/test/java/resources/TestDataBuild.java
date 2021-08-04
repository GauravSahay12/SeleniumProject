package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_PogoMain_serialize;

public class TestDataBuild {
	
	public Add_PogoMain_serialize AddPlacePayload() {
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
		      return ap;
	}

}
