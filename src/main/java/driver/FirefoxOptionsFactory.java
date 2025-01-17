package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOptionsFactory {
    FirefoxOptions build(){
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.addArguments("start-maximized");
        optionsFirefox.addArguments("lang=en-US");
        optionsFirefox.setAcceptInsecureCerts(true);
        return optionsFirefox;
    }


}
