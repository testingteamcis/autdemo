Feature: Validate Place Validations Functionality
@Addplace @regression
  Scenario Outline: Verify if place is successfully added into the AddPlaceAPI
    Given Validate Add place API payload name "<name>" languauge "<language>" and phonenumber "<phonenumber>"
    When user call  "AddplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    And  Validate the name "<name>" should match with getresponse "GetplaceApi" with using "GET" https request method 
    
   Examples:
   			| name | language | phonenumber |
   			| Pavan | Hindi | 9533745789|
   		
 @Addplace @smoke
  Scenario Outline: Verify if  delete place is successfully added into the AddPlaceAPI
    Given get the delete payload
    When user call  "DeleteplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    
    
 @getplace	@regression
  Scenario Outline: Verify if get place is successfully fetch into the AddPlaceAPI
    Given Validate Add place API payload name "<name>" languauge "<language>" and phonenumber "<phonenumber>"
    When user call  "AddplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    And  Validate the name "<name>" should match with getresponse "GetplaceApi" with using "GET" https request method 
    
   Examples:
   			| name | language | phonenumber |
   			| Pavan | Hindi | 9533745789|
   			
   			
  @addandget	@regression
  Scenario Outline: Verify if fetch place is successfully fetch into the AddPlaceAPI
    Given Validate Add place API payload name "<name>" languauge "<language>" and phonenumber "<phonenumber>"
    When user call  "AddplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    And  Validate the name "<name>" should match with getresponse "GetplaceApi" with using "GET" https request method 
    
   Examples:
   			| name | language | phonenumber |
   			| Pavan | Hindi | 9533745789|
 
   		
 @getplace @sanity
  Scenario Outline: Verify if get place is successfully fetch into the AddPlaceAPI
    Given get the delete payload
    When user call  "DeleteplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
 
 @getplace	@regression
  Scenario Outline: Verify if get place is successfully fetch into the AddPlaceAPI
    Given Validate Add place API payload name "<name>" languauge "<language>" and phonenumber "<phonenumber>"
    When user call  "AddplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
    And  Validate the name "<name>" should match with getresponse "GetplaceApi" with using "GET" https request method 
    
   Examples:
   			| name | language | phonenumber |
   			| Pavan | Hindi | 9533745789|
 
   		
 @getplace @sanity
  Scenario Outline: Verify if get1 place is successfully fetch into the AddPlaceAPI
    Given get the delete payload
    When user call  "DeleteplaceApi" using "POST" http request method  
    Then validate Api call is success status code is 200
    And "status" code is "OK"
 
    
 
  