package StepDefinition;

import Pages.Dashboard;
import Runner.TestRunner;
import io.cucumber.java.en.Then;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DashboardPageStepDef {

    private static final Log log = LogFactory.getLog(DashboardPageStepDef.class);
    private static WebDriver driver;
    private static String webURL;
    Dashboard dashboard = new Dashboard();


    static {
        // Load configuration from the Runner class
        driver = TestRunner.driver;
        webURL = TestRunner.webURL;
    }
    public DashboardPageStepDef() {
    }

    @Then("User click on hamburger")
    public void user_click_on_hamburger() throws InterruptedException {
        dashboard.hamburgerClick();
    }

    @Then("User logout from dashboard and navigate back to {string}")
    public void user_logout_from_dashboard_and_navigate_back_to(String loginTitle) throws InterruptedException {
        dashboard.logoutClickandValidateLoginPage(loginTitle);
    }

    @Then("I should see the menu items {string}")
    public void verify_menu_items(String menuItems)  {
       // Thread.sleep(2000);
        String[] expectedItems = menuItems.split(",\\s*"); // Split by comma and optional space
        System.out.println("======="+ Arrays.toString(expectedItems));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='navbar-nav']"))); // Adjust as necessary

        List<WebElement> menuElements = driver.findElements(By.xpath("//ul[@class='navbar-nav']"));
        System.out.println("Found menu items:");
        for (WebElement item : menuElements) {
            System.out.println(item.getText().replaceAll("\\s+", ", "));
        }

        for (String expectedItem : expectedItems) {
            boolean found = menuElements.stream()
                    .anyMatch(element -> element.getText().equals(expectedItem));
            assertTrue("Menu item '" + expectedItem + "' not found", found);
        }
    }

}
