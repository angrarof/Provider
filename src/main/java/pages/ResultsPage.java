package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.DriverSetup;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage {

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdownButton;

    @FindBy(xpath = "//*[@data-test-id='listing-price-dollars']")
    private List<WebElement> flightPrices;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSortDropdownButton() { return sortDropdownButton; }

    public List<WebElement> getFlightPrices() { return flightPrices; }

    public List<Integer> getPrices() {
        List<Integer> newPrices = new ArrayList<>();
        for(WebElement price : flightPrices){
            newPrices.add(Integer.parseInt(price.getText().replace("$","").replace(",","").replace("MXN","")));
        }
        return newPrices;
    }
}
