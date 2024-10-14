package Pages;

import Runner.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Dashboard {

    private static WebDriver driver;
    private static String webURL;
  //  LoginPage loginPage = new LoginPage();


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


}
