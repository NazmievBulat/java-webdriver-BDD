package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class UpsPickupService extends UpsControls {



    @FindBy(xpath = "//*[contains(@id,'nbsServiceTileTotalCharge')]")
    private List<WebElement> prices;

    @FindBy(css = ".serviceCard_wrapper")
    private List<WebElement> cards;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement continueButton;

    private WebElement getElementByPrice(String price){

        return getDriver().findElement(By.xpath("//*[contains(@id,'nbsServiceTileTotalCharge')][contains(text(),'" + price + "')]/../.."));
    }

    public void getCheapestPrice() {
        double cheapestPrice = Double.MAX_VALUE;
        WebElement cheapestElement = null;
        for (WebElement e : prices) {
            String getPrices = e.getText();
            String cleanPrices = getPrices.replace("$", "");
//            System.out.println(getPrices);
            double elementPrice = Double.parseDouble(cleanPrices);
            System.out.println(elementPrice);

            if (elementPrice < cheapestPrice){
                cheapestPrice = elementPrice;
                cheapestElement = e;
            }

            }
        System.out.println("Cheapest price "+ cheapestPrice);
        String cheapestPriceString = String.valueOf(cheapestPrice);
            getElementByPrice(cheapestPriceString).click();



//       cards.get(cards.size()-1).click();
        scrollWindowWithJs("800");
    }

}
