Feature: data driven testing using cucumber 
  
  Scenario: Successful Login with Valid Credentials
	Given user is on Login page "https://phptravels.org/clientarea.php"
	And User enters Credentials to LogIn
	  |username    |password|
    | testuser_1 | Test@153 |
    |testuser_1  | Test@153|  
	Then Message displayed Login Successfully
	
	
 
    
    
 


    

    
	