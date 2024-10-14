package Pages;

import Runner.TestRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class FetchOTP {

    private static WebDriver driver;
    private static String webURL;
  //  LoginPage loginPage = new LoginPage();
  private Response response;
    private String requestBody;

    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }

    public void hamburgerClick() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='user-profile-menu d-md-block d-sm-none d-xs-none d-none ml-auto']//div[@class='cursor-pointer avatar']")).click();
   Thread.sleep(2000);
    }

    public void logoutClickandValidateLoginPage(String loginTitle) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        String LoginPageURL = "https://dev.incredmoney.com/login/";
        WebElement logoutButton = driver.findElement(By.xpath("//p[normalize-space()='Logout']"));
        logoutButton.click();
        wait.until(ExpectedConditions.urlToBe(LoginPageURL));
        String loginPageTitle = driver.getTitle();
        System.out.println("Title of Login Page :- "+loginPageTitle);
        Assert.assertEquals(loginTitle, loginPageTitle);
    }

    public void reqPayloadValues() {
        // Define your request payload with nested query and four values
        requestBody = "{ " +
                "\"query\": { " +
                "\"key\": { " +
                "\"$in\": [\"+919960224516\", \"91.9960224516@phone.oro\"] " +
                "} " +
                "}, " +
                "\"email\": \"connect@incredmoney.com\", " +
                "\"typeAuth\": \"afzQCubiFM9MZLn8oQFzxE3I7NkCbajk\", " +
                "\"db\": \"orowealth\", " +
                "\"collection\": \"otps\" " +
                "}";
    }

    public void sendRequestToOTPEndpoint() {
        // Set the base URI
        RestAssured.baseURI = "https://uatapi.incredmoney.com"; //API base URI

        // Send POST request and capture the response
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/dev/getData") // specific endpoint
                .then()
                .extract().response();
    }

    public void reponseOTPValidation() {
        // Proceed to parse the JSON response
        String responseBody = response.asString();
        System.out.println("Response Body: " + responseBody); // Check if this is valid JSON
        System.out.println("Full Response: " + response.prettyPrint());
        // Extract the OTP from the response body
        String otp = response.jsonPath().getString("docs[1].otp");
        // Validate the OTP
        assertThat(otp, is(notNullValue()));
        assertThat(otp.length(), is(4)); // Assuming OTP is a 4-digit number
        System.out.println("Received OTP: " + otp);
    }
}
