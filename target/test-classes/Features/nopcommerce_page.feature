

Feature: Login
  
  @smoketest
  Scenario: Successful login with valid Credentials
    Given User launch Chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then Page title shold be "Dashboard / nopCommerce administration"
    When User click on logout button
    Then Page title should be "Your store. Login"
 	  And Close browser
 	  
 	   

