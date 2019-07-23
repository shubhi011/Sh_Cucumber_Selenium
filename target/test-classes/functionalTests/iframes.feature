Feature: Working with iframes

Background:
    Given I navigate to the webpage "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe"
    
Scenario: Click on element present in Iframe  
    When i click on element present in iframe then it should be successful
    And close the browser
    
 Scenario: Working with multiple window
     Given i open the web page "https://www.w3schools.com/js/js_popup.asp"
     When i click on a button it will open child window
     Then click on home button
     And close the browser
    
 