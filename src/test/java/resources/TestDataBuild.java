package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_PogoMain_serialize;

public class TestDataBuild {
	
	public Add_PogoMain_serialize AddPlacePayload(String name , String language, String address) {
		  pojo.Add_PogoMain_serialize ap =new pojo.Add_PogoMain_serialize();
		  	
		  	ap.setAccuracy(50);
		  	ap.setName(name);
		  	ap.setAddress(address);
		  	ap.setLanguage(language);
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

	public String Deletepayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";		
    }
}
