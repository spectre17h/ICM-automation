package StepDefinition;

import Pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Runner.TestRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPageStepDef {

    private static final Log log = LogFactory.getLog(LoginPageStepDef.class);
    private static WebDriver driver;
    private static String webURL;
    LoginPage loginPage = new LoginPage();


    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }
    public LoginPageStepDef() {
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException, PendingException {
        // Initialize WebDriver (make sure to set the path to your WebDriver executable)
        // Navigate to the given page URL
        loginPage.loginPageNavigation();
        /*driver.get(webURL);
        driver.manage().window().maximize();
        Thread.sleep(1000);*/
    }

    @Then("I should see the text {string}")
    public void i_should_see_the_text(String expectedText) {
       loginPage.loginPageUIContentValidation(expectedText);
    }

    @And("Terms and Conditions should be as {string}")
    public void terms_and_conditions_should_be_as_(String expectedTandC) {
        loginPage.tAndCValidation(expectedTandC);
    }

    @And("Validate {string} on the button")
    public void validate_on_the_button(String text) throws InterruptedException {
        loginPage.buttonTextValidation(text);
    }

    @Then("Validate left side header {string}")
    public void validate_left_side_header(String header) {
        loginPage.leftSideHeaderValidation(header);
    }

    @When("User enters {string}")
    public void user_enters(String mobileNumber) throws InterruptedException {
        loginPage.mobileNumberSendCheck(mobileNumber);
    }

    @Then("Click on login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.loginButtonClick();
    }

    @Then("User land on OTP screen and enters wrong {string}")
    public void user_land_on_OTP_screen_and_enters_wrong(String wrongOtp) throws InterruptedException {
        loginPage.worngOTPValidation(wrongOtp);
    }

    @Then("Validate the error {string}")
    public void validate_the_error(String error) throws InterruptedException {
        loginPage.otpErrorMessageValidation(error);
    }

    @Then("User land on OTP screen and enters {string}")
    public void user_land_on_OTP_screen_and_enters(String otp) throws InterruptedException {
        loginPage.submitOTPValidate(otp);
    }

    @Then("Verify user is on homepage with the {string}")
    public void verify_user_is_on_homepage_with_the(String user) {
        loginPage.homePageRedirectionValidation(user);
    }

    @Then("Validate image on login page")
    public void validate_image_on_login_page() {
        WebElement imageLogo = driver.findElement(By.xpath("//img[@alt='incred-money-logo']"));
        Assert.assertTrue(imageLogo.isDisplayed());
    }

    @Then("Verify error {string}")
    public void verify_error(String mob_error_message) {
        loginPage.mobile_Error_message_Validation(mob_error_message);
    }

    @Then("Click on Terms and conditions hyperlink")
    public void click_on_terms_and_conditions_hyperlink() {
        loginPage.termsAndConditionClick();
    }

    @Then("Validate Terms and Conditions {string}")
    public void validate_terms_and_conditions(String tAndC_url) throws InterruptedException {
        loginPage.termsAndConditionsURL(tAndC_url);

    }
}
