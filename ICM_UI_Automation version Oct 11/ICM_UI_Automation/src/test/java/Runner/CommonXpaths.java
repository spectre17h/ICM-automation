package Runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonXpaths {
    private static WebDriver driver;
    private static String webURL;
    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }

    /*Login Page XPaths*/
    public static WebElement welComeText() {
    return driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[1]/div/p"));
    }
    public static WebElement termsAndConditions() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div[2]/p"));
    }
    public static WebElement submitButton() {
        return driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div[2]/button"));
    }
    public static WebElement headerElement() {
        return driver.findElement(By.xpath("//*[@class='title text-left']"));
    }
    public static WebElement mobNumber() {
        return driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
    }
    public static WebElement loginButton() {
        return driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
    }
    public static WebElement otpNumber() {
        return driver.findElement(By.xpath("//input[@name='num-1']"));
    }
    public static WebElement verifyButton() {
        return driver.findElement(By.xpath("//button[normalize-space()='Verify']"));
    }
    public static WebElement submitOtpNumber() {
        return driver.findElement(By.xpath("//input[@name='otp']"));
    }
    public static WebElement submitVerifyButton() {
        return driver.findElement(By.xpath("//button[normalize-space()='Verify']"));
    }
    public static WebElement cardUE() {
        return driver.findElement(By.xpath("//p[normalize-space()='Invest in Pre IPO | Unlisted Shares']"));
    }
    public static WebElement mobile_error_message() {
        return driver.findElement(By.xpath("//span[@class='font-size-tiny text-danger mt-2']"));
    }
    public static WebElement termsAndConditionClick() {
        return driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']"));
    }
}
