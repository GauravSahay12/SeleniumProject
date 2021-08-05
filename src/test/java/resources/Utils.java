package resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils  {
	

	public static RequestSpecification  Spec_Request;
	
	public static ResponseSpecification Spec_Response;
	
	
	public RequestSpecification RequestSpecification() throws IOException  {
		
		if(Spec_Request==null) {
		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		
		 Spec_Request =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
			     .addFilter(RequestLoggingFilter.logRequestTo(log)) 
			     .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		 return Spec_Request;
	}
	return Spec_Request;// Second time when this called this value will not be null so we makes it as static in declaration
	}
	
	public ResponseSpecification ResponseSpecification()  {
		
		Spec_Response=new ResponseSpecBuilder().expectStatusCode(200)
				
				.expectContentType(ContentType.JSON).build();
		  
		 return Spec_Response;
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		String path=System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path+"\\src\\test\\java\\resources\\global.properties");
	    prop.load(fis);
	    return prop.getProperty(key);
    	
	}
	
	public String JsonPath(Response Response1 , String key) {
		String resp=Response1.asString();
		   JsonPath jp=new JsonPath(resp);
		   return jp.get(key).toString();
		   
		 
	}
}
