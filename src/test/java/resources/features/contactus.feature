@shivsahil
Feature: Submit data to webdriveruniversity.com using contact us form

Scenario: Submit valid data via contact us form
	Given I access webdriveruniversity contact us form
	When I enter a valid firstname as "Sahil"
	When I enter a valid last name
	| woods | Shiva | jones |
	And i enter a valid email address as "webdriveruniversity@outlook.com"
	And i enter comments
	|example comment one | example comment two |
	When i click on the submit button
	Then the information should successfully be submitted via the contact us form