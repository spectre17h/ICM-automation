package Pages;
import Runner.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class PreLogin {
    private static WebDriver driver;
    private static String webURL;
    WebElement detailsNextButton = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }

    public void PreLoginLandingPage() throws InterruptedException {
        String preLoginURL = "https://dev.incredmoney.com/";
        driver.get(preLoginURL);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    public void preLoginTitleValidate(String preLoginTitle) {
        String title = driver.getTitle();
        String cleanedText = title.replace("|", "");
        //System.out.println("======="+cleanedText);
        Assert.assertEquals(cleanedText, preLoginTitle);
    }

    public void menuContentValidation(List<String> expectedItems) {// Locate the Menubar, Example Domain doesn't have a real menubar, so use header tag
        WebElement header = driver.findElement(By.xpath("//div[@class='justify-content-start collapse navbar-collapse']")); // This is a placeholder; modify as needed

        // Find the text of the header
        String menuText = header.getText();
        //String formatedMenuText = menuText.replace(" ", "");
        System.out.println("Menu Contents are:- "+menuText);
        // Example Domain does not have a menu, this step is illustrative
        for (String item : expectedItems) {
            boolean found = menuText.contains(item);
            assertTrue("Menu item '" + item + "' is not found", found);
        }
       // Assert.assertEquals(expectedItems, menuText);
    }

    public void loginButtonClick() {
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
    }
    public void signupButtonClick() {
        WebElement signupButton = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
        signupButton.click();
    }
/*
    public void userDetails(String fullName, String email) throws InterruptedException {
        WebElement full_name = driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
        full_name.clear();
        full_name.sendKeys(fullName);

        WebElement email_element = driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
        email_element.clear();
        email_element.sendKeys(email);

        Thread.sleep(2000);
        System.out.println("Mobile Number is:- "+fullName);
        System.out.println("Mobile Number is:- "+email);
    }

    public void detailsNextButtonClick() {
       // WebElement detailsNextButton = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        detailsNextButton.click();
    }

    public void hearAboutUsCheck() {
        WebElement fb_Insta_Button = driver.findElement(By.xpath("//button[normalize-space()='Facebook/Instagram']"));
        fb_Insta_Button.click();
        detailsNextButton.click();
    }

    public void investPlanCheck() {
        WebElement more_than_five_Lakh_button = driver.findElement(By.xpath("//button[@class='selectedQuestion-button btn btn-outline-secondary']"));
        more_than_five_Lakh_button.click();
        detailsNextButton.click();
    }*/
}
