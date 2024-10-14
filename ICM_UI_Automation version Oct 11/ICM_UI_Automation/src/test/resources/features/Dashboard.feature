@allValidation
Feature: Validate Dashboard Scenarios

  @logout
  Scenario Outline: Validate logout functionality
    Given I am on the login page
    When User enters "<mobileNumber>"
    Then Click on login button
    Then User land on OTP screen and enters "<otp>"
    Then User click on hamburger
    Then User logout from dashboard and navigate back to "<loginPage>"
    Examples:
      |mobileNumber|otp|loginPage|
      | 1000101543 |  1543 | Login or Signup on InCred Money|


  @menuaaa
  Scenario Outline: Validate logout functionality
    Given I am on the login page
    When User enters "<mobileNumber>"
    Then Click on login button
    Then User land on OTP screen and enters "<otp>"
    Then I should see the menu items "<menuItems>"

    Examples:
      |mobileNumber|otp| menuItems |
      | 1000101543 |  1543 | Home, Fixed Deposits, Bonds, Unlisted Shares, NEW, Portfolio, Refer, Learn  |