package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpsControls extends Page{
    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelButton;

    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement yesCancelButton;

    @FindBy(id = "nbsBackForwardNavigationReviewPrimaryButton")
    private WebElement reviewButton;

    @FindBy(css = ".serviceCard_footer-price")
    private WebElement totalCharges;


    public boolean waitTotalCharges() {
        try{
            getWait().until(ExpectedConditions.visibilityOf(totalCharges));
        } catch (NoSuchElementException | TimeoutException e){
            return false;
        }
        return !totalCharges.getText().isEmpty();
    }

//    public void clickContinue(){
//       if (continueButton.isDisplayed()){
//           continueButton.click();
//       }
//       else { reviewButton.click();
//        }
//    }
    public void clickContinue() {
        try {
            continueButton.click();
        } catch (Exception e) {
            reviewButton.click();
        }
    }

    public void clickCancel(){
        cancelButton.click();
        yesCancelButton.click();

    }

}
