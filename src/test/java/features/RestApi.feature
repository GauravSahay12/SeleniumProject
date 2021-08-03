Feature: Validate place Api

Scenario: Verify to add place using Add RestApi
   Given For the given request payload 
   When method is post and necessary url is provided
   Then API call got success with status code "200"
   And "status" in Response should generate with value "OK" 
   And "scope" in Response should generate with value "APP"  
