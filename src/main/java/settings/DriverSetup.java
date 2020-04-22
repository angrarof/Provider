package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverSetup {

    private WebDriver driver;

    public DriverSetup(String browserName, boolean headless) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (headless) {
                chromeOptions.addArguments("--headless");
            }
            driver = new ChromeDriver(chromeOptions);
        }
        else {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            if(headless) {
                firefoxOptions.addArguments("--headless");
            }
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WaitingTimeSetup.getTimeToImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WaitingTimeSetup.getTimeForPageLoad(), TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
