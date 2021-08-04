package resources;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils  {
	

	RequestSpecification  Spec_Request;
	
	ResponseSpecification Spec_Response;
	
	
	public RequestSpecification RequestSpecification() throws FileNotFoundException  {
		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		
		 Spec_Request =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
			     .addFilter(RequestLoggingFilter.logRequestTo(log)) 
			     .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		 return Spec_Request;
	}
	public ResponseSpecification ResponseSpecification()  {
		
		Spec_Response=new ResponseSpecBuilder().expectStatusCode(200)
				
				.expectContentType(ContentType.JSON).build();
		  
		 return Spec_Response;
	}

}
