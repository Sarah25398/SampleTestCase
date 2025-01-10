package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class BaseCommon {
    public static WebDriver driver;
    public BaseCommon(WebDriver driver){
        this.driver =driver;
    }

    public void ClickElement(String xpath){
        this.waitForElementToVisible(xpath);
        driver.findElement(By.xpath(xpath)).click();

    }

    public void waitForElementToVisible(String xpath) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
