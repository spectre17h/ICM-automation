@ValidateOTP
Feature: OTP Retrieval
  Scenario: Retrieve OTP from POST response
    Given I have the request payload with required values
    When I send a POST request to the OTP endpoint
    Then I should get a valid OTP from the response