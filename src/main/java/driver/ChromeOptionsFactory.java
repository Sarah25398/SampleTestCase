package driver;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeOptionsFactory {
    ChromeOptions build(){
        ChromeOptions optionsChrome = new ChromeOptions();
        /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\vela.os010\\AppData\\Local\\Google\\Chrome\\User Data");
     
        optionsChrome.addArguments("user-data-dir=" + "C:\\Users\\vela.os010\\AppData\\Local\\Google\\Chrome\\User Data");
        optionsChrome.addArguments("profile-directory=Default");

         */
        optionsChrome.addArguments("start-maximized");
        optionsChrome.addArguments("lang=en-US");
        optionsChrome.setAcceptInsecureCerts(true);
        return optionsChrome;
    }
}
