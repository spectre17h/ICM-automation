package StepDefinition;

import Pages.LoginPage;
import Pages.PreLogin;
import Runner.TestRunner;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.AN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PreLoginPageStepDef {

    private static final Log log = LogFactory.getLog(PreLoginPageStepDef.class);
    private static WebDriver driver;
    private static String webURL;
    PreLogin preLogin = new PreLogin();

    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }
    public PreLoginPageStepDef() {
    }

    @Given("User hits Pre-Login URL")
    public void user_hits_pre_login_url() throws InterruptedException {
        preLogin.PreLoginLandingPage();
    }

    @Then("Verify user is on Pre-login page using {string}")
    public void verify_user_is_on_pre_login_page(String pre_login_Title){
        preLogin.preLoginTitleValidate(pre_login_Title);
    }

    @Then("Verify header contents:")
    public void verify_header_contents(List<String> expectedItems)  {
        preLogin.menuContentValidation(expectedItems);
    }

    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {
        preLogin.loginButtonClick();
    }

    @Then("User clicks on Signup button")
    public void user_clicks_on_Signup_button() {
        preLogin.signupButtonClick();
    }
/*
    @When("User enters {string} and {string}")
    public void user_enters_and_signup_and_login(String full_name, String email) throws InterruptedException {
        preLogin.userDetails(full_name,email);
    }

    @And("Click on next button")
    public void click_on_next_button() {
        preLogin.detailsNextButtonClick();
    }

    @And("Where do you hear about us check select")
    public void where_do_you_hear_about_us_check_select() {
        preLogin.hearAboutUsCheck();
    }

    @And("Invest Plan Check Select")
    public void invest_plan_check_select() {
        preLogin.investPlanCheck();
    }*/

}
