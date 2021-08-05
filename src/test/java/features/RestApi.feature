Feature: Validate place Api

Scenario Outline: Verify to add place using Add RestApi
   Given For the given request payload "<name>" "<language>" "<address>"
   When User calls "AddPlaceAPI" with "POST" http request
   Then API call got success with status code "200"
   And "status" in Response should generate with value "OK" 
   And "scope" in Response should generate with value "APP"  

Examples:
     |name|language|address|
     |ABC House|English|World Cross Center|
     |XYZ House|Hindi  |Sea Cross Zone|