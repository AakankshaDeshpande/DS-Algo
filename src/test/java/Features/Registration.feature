
Feature: Registration Testing
 #Scenario: Registration with Valid Data
    #Given I am on the registration page
    #When I fill in the registration form with valid data
    #Then I should see a success message

  Scenario Outline: Registration with Invalid Data
    Given I am on the registration page
    When I fill in the registration form with invalid data <username>, <password>, and <confirmPassword>
    Then I should see an error-success message

    Examples:
      | username    | password     	| confirmPassword |        
      |  sdet1234   |     sdet1   	| sdet12      		|
      | sdet12      |               | numpay     			|
      |             |numpy@12345   	|      			|
      | sdet1       | 12345   			| 12345     |
   