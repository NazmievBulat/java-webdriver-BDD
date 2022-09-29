package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsShipSummary extends UpsControls{

    @FindBy(xpath = "//div[@id='origin_showSummaryAddress']")
    private WebElement shipFromSummary;

    @FindBy(xpath = "//div[@id='destination_showSummaryAddress']")
    private WebElement shipToSummary;

    @FindBy(xpath = "//span[@id='nbsWeightPkgReview1']")
    private WebElement weightSummary;

    @FindBy(xpath = "//span[@id='nbsPackageDimensionsPkgReview1']")
    private WebElement dimensionSummary;


    public String getShipFromSummary(){
        return shipFromSummary.getText();
    }

    public String getShipToSummary(){
        return shipToSummary.getText();
    }


    public String getWeightFromSummary(){
        return weightSummary.getText();
    }


    public String getDimensionFromSummary(){
        return dimensionSummary.getText();
    }
}
