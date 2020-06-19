package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGrid {
    DesiredCapabilities capability = null;
    WebDriver driver;


    @BeforeTest
    @Parameters({"browser","nodeUrl"})
    public void launchBrowser(String browser, String url) throws Exception {
        switch (browser){
            case "chrome":
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.ANY);
                break;
            default:
                Assert.fail("Verify your browser selection");
                break;
        }
        driver = new RemoteWebDriver(new URL(url), capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void testSelenoumGrid(){
        System.out.println("Testing selenium grid");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
