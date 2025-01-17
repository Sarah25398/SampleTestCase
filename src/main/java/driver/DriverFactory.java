package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory{
    ChromeLocalDriverFactory chromeLocalDriverFactory;
    FirefoxLocalDriverFactory firefoxLocalDriverFactory;

    public DriverFactory(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptionsFactory().build();
            chromeLocalDriverFactory = new ChromeLocalDriverFactory(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptionsFactory().build();
            firefoxLocalDriverFactory = new FirefoxLocalDriverFactory(firefoxOptions);
        }
    }

    public WebDriver createInstance(){
        if(chromeLocalDriverFactory != null) {
            return chromeLocalDriverFactory.driver();
        } else if (firefoxLocalDriverFactory !=null) {
            return firefoxLocalDriverFactory.driver();

        }
        else {
            throw new IllegalArgumentException("Not Supported Browser");
        }

    }

}
