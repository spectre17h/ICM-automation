package StepDefinition;

import Pages.FetchOTP;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FetchOTPStepDef {
    FetchOTP fetchOTP = new FetchOTP();


    @Given("I have the request payload with required values")
    public void i_have_the_request_payload_with_required_values() {
        fetchOTP.reqPayloadValues();
    }

    @When("I send a POST request to the OTP endpoint")
    public void i_send_a_post_request_to_the_otp_endpoint() {
        fetchOTP.sendRequestToOTPEndpoint();

    }

    @Then("I should get a valid OTP from the response")
    public void i_should_get_a_valid_otp_from_the_response() {
        fetchOTP.reponseOTPValidation();
    }
}

