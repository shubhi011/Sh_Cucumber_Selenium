Feature: Working with Alerts

Background:
   Given Alerts_I navigate to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert"
    
Scenario: Handling Alerts
    When i click on Try_It button it should show the alert
    And i switch to alert and accept the alert
    Then i switch to default content
    And i close the browser
 
Scenario: Working with confirmation popup
    When i navigate to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm"
    When i click on Try_It button it should show the alert
    And i switch to alert and accept the alert
    Then i switch to default content
    And i close the browser
    
Scenario: Working with prompt
    When i navigate to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
    When i click on Try_It button it should show the alert
    And i provide string as "Sample text"
    And i switch to alert and accept the alert
    Then i click on Tryit button again
    And i get the string of the prompt
    And i switch to the alert and cancel it
    Then i switch to default content
    And i close the browser
  
 Scenario: Handling bootstrap pop up
    Given i open to the webpage "https://www.w3schools.com/bootstrap/bootstrap_modal.asp"
    When i click on open model button
    Then it should open the bootstrap popup
    And i click on close button to close the pop up
    And i close the browser