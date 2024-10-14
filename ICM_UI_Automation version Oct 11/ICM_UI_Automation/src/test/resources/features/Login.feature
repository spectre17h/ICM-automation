@allValidationsss
Feature: Validate text on a ICM Login web page

    @rightside
  Scenario Outline: Validate contents on the right side on the web page
    Given I am on the login page
    Then I should see the text "<expectedText>"
    And Terms and Conditions should be as "<expectedTandC>"
    And Validate "<text>" on the button

    Examples:
      |  expectedText | expectedTandC | text |
      | Welcome to InCred Money |By proceeding, I accept the Terms & Conditions, and agree to receive messages such as OTPs & important updates on WhatsApp.| Next |

  @validate213
  Scenario: Validate contents on the left side on the web page
    Given I am on the login page
    Then Validate left side header "Pre IPO | Unlisted Shares"

@validatethis
  Scenario Outline: Validate wrong OTP Error message
    Given I am on the login page
    When User enters "<mobileNumber>"
    Then Click on login button
    Then User land on OTP screen and enters wrong "<otp>"
    Then Validate the error "<message>"
    Examples:
      |mobileNumber|otp|message |
      | 1000101543 |  1548 |The OTP entered is invalid. Please generate a new OTP|


  @imageDisplay
  Scenario: ICM Image logo validation
    Given I am on the login page
    Then Validate image on login page

  @mob_error
  Scenario Outline: Verify wrong mobile number error message
    Given I am on the login page
    When User enters "<mobileNumber>"
    Then Click on login button
    Then Verify error "<message>"
    Examples:
      |mobileNumber| message |
      | 1000101 | Please enter a valid mobile number |

  @TAndC
  Scenario Outline: Verify Terms and Conditions click check
    Given I am on the login page
    Then Click on Terms and conditions hyperlink
    Then Validate Terms and Conditions "<URL>"
    Examples:
      | URL |
      | https://dev.incredmoney.com/terms-of-use/    |

  #@scas REPEATED SCENARIO
  #Scenario Outline: Validate header contents on the Login Page
   # Given I am on the login page
    #When User enters "<mobileNumber>"
    #Then Click on login button
    #Then User land on OTP screen and enters "<otp>"
    #Then Verify user is on homepage with the "Incred Money - Alternate Investment Platform"
    #Examples:
     # |mobileNumber|otp|
      #| 1000101543 |  1543 |


  @akshay
  Scenario Outline: Validate Login to Dashboard for ICM
    Given I am on the login page
    When User enters "<mobileNumber>"
    Then Click on login button
    Then User land on OTP screen and enters "<otp>"
    Then Verify user is on homepage with the "Incred Money - Alternate Investment Platform"
    Examples:
      |mobileNumber|otp|
      | 1000101543 |  1543 |
