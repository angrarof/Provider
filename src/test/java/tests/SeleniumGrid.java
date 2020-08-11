package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGrid {
    private  DesiredCapabilities capability = null;
    private  ChromeOptions chromeOptions;
    private  WebDriver driver;


    @BeforeTest
    @Parameters({"browser","nodeUrl"})
    public void launchBrowser(String browser, String url) throws Exception {
        //String browser = "chrome";
        //String url="http://192.168.100.17:5566/wd/hub/";
        switch (browser){
            case "chrome":
                chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME,"chrome");
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME,Platform.ANY);
                break;
            case "firefox":
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.ANY);
                break;
            case "explorer":
                capability = DesiredCapabilities.internetExplorer();
                capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability("ignoreProtectedModeSettings", true);
                capability.setCapability("nativeEvents", false);
                capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
                capability.setCapability(InternetExplorerDriver.LOG_LEVEL, "DEBUG");
                break;
            default:
                Assert.fail("Verify your browser selection");
                break;
        }

        if (browser.equalsIgnoreCase("chrome")){
            driver = new RemoteWebDriver(new URL(url), chromeOptions);
        }else {
            driver = new RemoteWebDriver(new URL(url),capability);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    @Parameters({"browser"})
    public void testSelenoumGrid(String browser){
        System.out.println("Testing selenium grid from: "+browser);
    }

    @Test(groups = "regression")
    public void enterText(){
        driver.findElement(By.name("q")).sendKeys("This is an example");
        driver.findElement(By.name("btnK")).submit();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
