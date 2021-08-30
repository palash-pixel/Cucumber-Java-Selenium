Feature: feature to test data driven log in functionnality

  # data driven
  @smoketest
  Scenario Outline: Chack login is successful with valid cradentioal
    Given User navigate to  log in page
    When Palash enter<email> and <password>
    And log in button clicked
    Then Now user login to forum

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin    |
