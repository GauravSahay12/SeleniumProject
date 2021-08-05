Feature: Validate place Api

Scenario Outline: Verify to add place using Add RestApi
   Given For the given request payload "<name>" "<language>" "<address>"
   When User calls "AddPlaceAPI" with "POST" http request
   Then API call got success with status code "200"
   And "status" in Response should generate with value "OK" 
   And "scope" in Response should generate with value "APP"  
   And verify place_id created maps to "<name>" using "GetPlaceApI"
   

Examples:
     |name|language|address|
     |ABC House|English|World Cross Center|
     |XYZ House|Hindi  |Sea Cross Zone|
     
Scenario: Verify to Delete place using Delete RestApi
Given Delete place payload
   When User calls "DeletePlaceAPI" with "POST" http request
   Then API call got success with status code "200"
   And "status" in Response should generate with value "OK" 