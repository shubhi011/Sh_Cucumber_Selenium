Feature: Web element functions 

Background: Common step 
    Given i open facebook home page "https://www.facebook.com/"
    
 
 Scenario: Web element function for single element
     When i provide a unique location to findelemnet api
     Then i should get that web element
     And browser is closed

Scenario: Working with textbox
    Given user enters "abc.com " in textbox
    When get text api is called it should return the text
    When clear api is called it should clear the text
    And browser is closed
    
Scenario: Working with button
    Given user performs click action on button
    

Scenario: Working with dropdown
    Given user selects drop down value based on visible text
    Given user selects drop down value based on index
    Given user selects drop down value based on value attribute
    When getOptions is called it should list all values in dropdown
     
 