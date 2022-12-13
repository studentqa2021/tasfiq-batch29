@SmokeTest
Feature: Login function Test 
@TC_1234
Scenario: As a Luma Application user, must do successful login with valid credential. 
	Given open any browser 
	And go to application URL 
	When click sign in button 
	And put user name 
	And put password 
	And click second signin button 
	Then validate login was successful 