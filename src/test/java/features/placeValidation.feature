Feature: Validating Place API's
@Regression @AddplaceApi
Scenario Outline: Verify if the place is being successfully added using "AddPlaceAPI" 
    Given Add Place Paylode "<name>" "<language>" "<address>"
     When User calls "deletePlaceAPI" with "get" http request
     Then The Api call got success with status code
      And "status" in response body is "OK"
      And "scope" in response body is "APP"
      
      
Examples:
		|name     |language |address          |
		|Pratheek |Kannada  |Raghuvanahalli   |
		|Prem     |Engilsh  |Konankunte Cross |