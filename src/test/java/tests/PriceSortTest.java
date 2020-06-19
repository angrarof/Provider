package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import pages.HomePage;
import pages.ResultsPage;
import settings.DriverSetup;
import settings.WaitingTimeSetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class PriceSortTest {

    private WebDriver driver;
    private Logger logger;
    private String travelFromCity;
    private String travelToCity;
    private String strDepartureDate;
    private String strReturnDate;

    private HomePage homePage;
    private ResultsPage resultsPage;

    //@BeforeClass
    public void setTest() {
        driver = new DriverSetup("chrome", true).getDriver();
        logger = LogManager.getLogger(this);
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        //driver.get("https://www.expedia.mx");
        logger.trace("Home Page loaded, beginning test.");
        travelFromCity = "SFO";
        travelToCity = "LAS";

        Calendar departureDate = Calendar.getInstance();
        departureDate.add(Calendar.DATE, 3);

        Calendar returnDate = Calendar.getInstance();
        departureDate.add(Calendar.DATE, 6);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        strDepartureDate = dateFormat.format(departureDate.getTime());
        strReturnDate = dateFormat.format(returnDate.getTime());
    }

    @Test(enabled = false)
    public void verifyPricesSortingIsWorking()   {
        logger.debug("Sending search criteria to required fields");
        homePage.getFlightsButton().click();
        homePage.getCityComingFromField().sendKeys(travelFromCity);
        homePage.getCityHeadingToField().click();
        homePage.getCityHeadingToField().sendKeys(travelToCity);
        homePage.getDepartureDateField().sendKeys(strDepartureDate);

        for(int i = 0; i < 10; i++){
            homePage.getReturnDateField().sendKeys(Keys.BACK_SPACE);
        }

        homePage.getReturnDateField().sendKeys(strReturnDate);
        homePage.getSearchButton().submit();

        new WebDriverWait(driver, WaitingTimeSetup.getTimeForWebElement()).
                until(ExpectedConditions.visibilityOfAllElements(resultsPage.getFlightPrices()));

        List<Integer> expectedPricesSorted = resultsPage.getPrices();
        Collections.reverse(expectedPricesSorted);

        new Select(resultsPage.getSortDropdownButton()).selectByValue("price:desc");

        new WebDriverWait(driver, WaitingTimeSetup.getTimeForWebElement()).
                until(ExpectedConditions.elementToBeClickable(resultsPage.getSortDropdownButton()));

        List<Integer> sortedPrices = resultsPage.getPrices();
        System.out.println(sortedPrices);

        boolean flag = true;
        for (int i=0; i<sortedPrices.size()-1; i++){
            if(sortedPrices.get(i)<sortedPrices.get(i+1)){
                flag = false;
                break;
            }
        }

        Assert.assertTrue(flag,"Bad sorting");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
