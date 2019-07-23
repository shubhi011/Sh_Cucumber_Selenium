Feature: Web driver wait function


Background:
    Given user opens the facebook homepage "https://www.facebook.com/"
    
Scenario: Implicit wait
    Given a precondition is valid
    When an action is performed
    Then something should be asserted