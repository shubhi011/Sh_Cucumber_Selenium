Feature: Working with mouse & keyboard actions


Scenario: Working with context click
    Given i open the webpage "https://demos.telerik.com/kendo-ui/dragdrop/events"
    When i create the composite action for context click
    And i build the action
    Then i perform the action
    And i take the screenshot
    
 
@smokeTest
Scenario: Working with drag & drop
    Given i open the webpage "https://demos.telerik.com/kendo-ui/dragdrop/events"
    When i create the composite action for drag & drop
    And i build the action
    Then i perform the action
@regression   
Scenario: Working with click and hold action
    Given i open the webpage "https://demos.telerik.com/kendo-ui/dragdrop/events"
    When i create the composite action for click and hold
    And i build the action
    Then i perform the action
    
 Scenario: Working with keyboard action
    Given i open the webpage "https://demos.telerik.com/kendo-ui/dragdrop/events"
    When i create the composite action for keyboard
    And i build the action
    Then i perform the action