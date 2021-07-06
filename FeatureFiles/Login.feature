#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Orange HRM

       @tag1
       		Scenario: i want to validate login.
       		Given i enter url in chrome browser.
       		When i enter username
       		And i enter password
       		When i click on login button
       		Then i verify text in url
       		Then i close browser
       		
       @tag2
       		Scenario Outline: login validate with multiple set of data
       		
       		Given user enters url in "<browser>"
       		When  user enters username "<username>" 
       		And user enters password "<password>" 
       		When user clicks of login button
       		Then user verifies text in url
       		Then user closes the browser
       		
       		Examples:
       		|browser|username|password| 
       		|chrome|Admin|Qedge123!@#|
       		|chrome|Admin|Qedge123!@#|

