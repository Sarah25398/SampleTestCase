package driver;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeOptionsFactory {
    ChromeOptions build(){
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
        optionsChrome.addArguments("lang=en-US");
        optionsChrome.setAcceptInsecureCerts(true);


        return optionsChrome;
    }
}
