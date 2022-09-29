package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;

public class UpsGuided extends UpsControls{

    @FindBy(id = "nbsShipmentDescription")
    private WebElement description;

    @FindBy(xpath = "//strong[normalize-space()=\"Deliver only to receiver's address (+$)\"]")
    private WebElement deliveryCheckBox;

    @FindBy(xpath = "//input[@id='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']")
    private WebElement verifyCheckBox;

    @FindBy(xpath = "//span[@id='total-charges-spinner']")
    private WebElement totalPrice;

    @FindBy(xpath = "//span[@class='icon ups-icon-paypal-light']")
    private WebElement selectPaypalIcon;


    public void fillDescription(String value){
        description.sendKeys(value);

    }
    public String getPreviousCharges(){
       return getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();
    }

    public void checkDeliverToAddress(){
        scrollWindowWithJs("500");
        clickWithActions(deliveryCheckBox);
    }
    public String verifyChangePrice(){
        return totalPrice.getText();
    }
    public void selectPaypal() throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(selectPaypalIcon));
        Thread.sleep(500);
        selectPaypalIcon.click();
        scrollWindowWithJs("500");
    }
}
