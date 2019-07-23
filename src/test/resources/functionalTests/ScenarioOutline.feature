Feature: To test scenario outline

Scenario Outline: scenario description
	Given user is on login page
		And enters username "<uname>"
		And password "<password>"
		
		Examples:
		| uname    | password|
		| test1    | pass1   |
		| test2    | pass2    |
		| test3    | pass3    |