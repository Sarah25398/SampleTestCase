package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefinitions {
    WebDriver driver;
    @io.cucumber.java.en.Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {

        driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }

    @io.cucumber.java.en.When("I enter valid credentials")
    public void iEnterValidCredentials() {
        // Implement code to input credentials
    }

    @io.cucumber.java.en.Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        // Implement verification code
        driver.quit();
    }
}
