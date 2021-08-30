

Feature: Login PNT fourm
  @pomtest
  Scenario: User Successfullly login with valid Credentials
    Given User launching Chrome browser
    When User navigate to url "https://forum.piit.us/"
    And user enters username as "testuser1" and Password as "abcd1234"
    And user Click on login
    Then Validate Page title shold be "Forum of PeopleNTech - Index"
    When click on logout button
   
 	  And Close the browser
