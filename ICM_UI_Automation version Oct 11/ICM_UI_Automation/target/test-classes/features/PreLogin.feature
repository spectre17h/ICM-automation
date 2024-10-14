Feature: Validate Pre-Login Page

  @prelogin
 Scenario Outline: Verify user is landed on Pre-Login Page using the title
  Given User hits Pre-Login URL
  Then Verify user is on Pre-login page using "<title>"
   Examples:
   |title|
   |Invest in Pre IPO  Unlisted Shares|

   @menubar
  Scenario: Validate header contents on the Pre-Login Page
   Given User hits Pre-Login URL
   Then Verify header contents:
   |About Us|
   |Products|
    |Refer|
    |Company|
    |Download App|
    |Learn|
   |Login|
   |Sign Up|

  @loginprelogin
  Scenario Outline: Validate Login from Pre-login
   Given User hits Pre-Login URL
   Then User clicks on login button
   When User enters "<mobileNumber>"
   Then Click on login button
   Then User land on OTP screen and enters "<otp>"
   Then Verify user is on homepage with the "Incred Money - Alternate Investment Platform"
   Then User click on hamburger
   Then User logout from dashboard and navigate back to "<loginPage>"
   Examples:
    |mobileNumber|otp|loginPage|
    | 1000101543 |  1543 |Login or Signup on InCred Money|

   @signup
   Scenario Outline: Sing-Up Functionality
    Given User hits Pre-Login URL
    Then User clicks on Signup button
    Then User enters "<mobileNumber>"
    Then Click on login button
    Then User land on OTP screen and enters "<otp>"
 # When User enters "<full_name>" and "<email>"
  #  And Click on next button
   # And Where do you hear about us check select
   # And Invest Plan Check Select
    Examples:
     |mobileNumber|otp|
     | 1000108681 |8681|
