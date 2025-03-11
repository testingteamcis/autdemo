Feature: Validate Add Place Api's
@Addplace
  Scenario Outline: Verify if place is successfully added into the AddPlaceAPI
    Given Validate Add place API payload name "<name>" languauge "<language>" and phonenumber "<phonenumber>"
    When user call  "AddplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    And  Validate the name "<name>" should match with getresponse "GetplaceApi" with using "GET" https request method 
    
   Examples:
   			| name | language | phonenumber |
   			| Pavan | Hindi | 9533745789|
   		
 @Addplace
  Scenario Outline: Verify if place is successfully added into the AddPlaceAPI
    Given get the delete payload
    When user call  "DeleteplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    
 
  