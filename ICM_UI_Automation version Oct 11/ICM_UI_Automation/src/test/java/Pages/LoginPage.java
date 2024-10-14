package Pages;
import Runner.CommonXpaths;
import org.junit.Assert;
import org.openqa.selenium.*;
import Runner.TestRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage {

    private static WebDriver driver;
    private static String webURL;

    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }
    public void loginPageNavigation() throws InterruptedException {
        driver.get(webURL);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    public void loginPageUIContentValidation(String expectedText){
        WebElement classElements = CommonXpaths.welComeText();
        // Get the actual text from the element
        String pageSource = classElements.getText();
        System.out.println("Contents on UI for Welcome message are:-"+pageSource);
        // Assert that the actual text matches the expected text
        assertTrue("Text not found: " + expectedText, pageSource.contains(expectedText));
    }

    public void tAndCValidation(String expectedTandC) {
        WebElement TandC = CommonXpaths.termsAndConditions();
        String TandCValues = TandC.getText();
        System.out.println("Contents on UI for Terms and Conditions are:- "+TandCValues);
        String assertMessage = String.format("Two texts are identical:===");
        assertEquals(assertMessage,expectedTandC, TandCValues);
    }

    public void buttonTextValidation(String text) throws InterruptedException {
        WebElement SubmitButtonText = CommonXpaths.submitButton();
        String buttonText = SubmitButtonText.getText();
        System.out.println("Button value is:- "+buttonText);
        String assertMessage = String.format("Two texts are identical:");
        assertTrue("Text not found ", buttonText.contains(text));
        Thread.sleep(3000);
    }

    public void leftSideHeaderValidation(String header) {
        WebElement headerElement = CommonXpaths.headerElement();
        String headerText = headerElement.getText();
        System.out.println("Header value is:- "+headerText);
    }
    public void mobileNumberSendCheck(String mobileNumber) throws InterruptedException {
        WebElement mobNumber = CommonXpaths.mobNumber();
        mobNumber.clear();
        mobNumber.sendKeys(mobileNumber);
        Thread.sleep(2000);
        System.out.println("Mobile Number is:- "+mobileNumber);
    }

    public void loginButtonClick() throws InterruptedException {
        WebElement loginButton = CommonXpaths.loginButton();
        loginButton.click();
        System.out.println("Login button clicked");
        Thread.sleep(5000);
    }

    public void worngOTPValidation(String wrongOtp) throws InterruptedException {
        WebElement otpNumber = CommonXpaths.otpNumber();
        otpNumber.sendKeys(wrongOtp);
        System.out.println("Wrong Mocked Otp is:- "+wrongOtp);
        WebElement verifyButton = CommonXpaths.verifyButton();
        Thread.sleep(4000);
        verifyButton.click();
    }

    public void otpErrorMessageValidation(String error) throws InterruptedException {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 3);
        WebElement toastMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'toast') and contains(text(), '" + error + "')]"))
        );
        String actualMessage = toastMessage.getText();
        assertEquals(error, actualMessage);
        Thread.sleep(2000);
    }

    public void submitOTPValidate(String otp) throws InterruptedException {
        WebElement submitOtpNumber = CommonXpaths.submitOtpNumber();
        submitOtpNumber.sendKeys(otp);
        System.out.println("Mocked Otp is:- "+otp);
        WebElement submitVerifyButton = CommonXpaths.submitVerifyButton();
        submitVerifyButton.click();
        Thread.sleep(3000);
        WebElement cardUE = CommonXpaths.cardUE();
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(cardUE));
    }

    public void homePageRedirectionValidation(String user) {
        String title = driver.getTitle();
        Assert.assertEquals(user, title);
    }

    public void mobile_Error_message_Validation(String mobErrorMessage) {
        WebElement mobile_error_message = CommonXpaths.mobile_error_message();
        String mob_error_msg = mobile_error_message.getText();
        System.out.println("Error message on wrong mobile number :- "+mob_error_msg);
        Assert.assertEquals(mobErrorMessage, mob_error_msg);
    }

    public void termsAndConditionClick() {
       CommonXpaths.termsAndConditionClick().click();
    }

    public void termsAndConditionsURL(String tAndCUrl) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + tAndCUrl + "', '_blank');");
        // Switch to the new tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Assuming the new tab is the second one
        Thread.sleep(2000);
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, tAndCUrl);
        // Switch back to the original tab
        driver.switchTo().window(tabs.get(0)); // Switch back to the original tab
    }
}
