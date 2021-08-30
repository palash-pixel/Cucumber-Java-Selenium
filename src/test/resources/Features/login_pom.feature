Feature: feature  log in functionnality validation

  @smoketest
  Scenario: Chack User login  successful with valid cradentioal
    Given User navigate to "https://forum.piit.us/"
    When Guest enters username and password
    And Guest Click on log in button
    Then Guest is navigate to the home page
# data driven
#@smoketest
  #Scenario Outline: Chack login is successful with valid cradentioal
    #Given User navigate to  log in page
    #When User enter <username> and <password>
    #And Click on log in button
    #Then User is navigate to the home page
#
    #Examples: 
      #| username  | password | 
      #| testuser2 | abcd1234 |
      #| testusr3 | abcd1234 | 
