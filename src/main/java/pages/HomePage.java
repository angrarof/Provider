package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightsButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement cityComingFromField;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement cityHeadingToField;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departureDateField;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returnDateField;

    @FindBy(xpath = "(//*[contains(text(),'Buscar')])[1]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFlightsButton() { return flightsButton; }
    public WebElement getCityComingFromField() { return cityComingFromField; }
    public WebElement getCityHeadingToField() { return cityHeadingToField; }
    public WebElement getDepartureDateField() { return departureDateField; }
    public WebElement getReturnDateField() { return returnDateField; }
    public WebElement getSearchButton() { return searchButton; }


}
