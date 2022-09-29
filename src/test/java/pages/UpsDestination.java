package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UpsDestination extends UpsPickupService{
    @FindBy(xpath = "//div[@id='origin_showSummaryAddress']")
    private WebElement resultsField;

    @FindBy(xpath = "//input[@id='destination-cac_companyOrName']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='destination-cac_singleLineAddress']")
    private WebElement address;

    @FindBy(xpath = "//ngb-typeahead-window/button")
    private List<WebElement> suggestionsList;

    @FindBy(xpath = "//button[@id='destination-singleLineAddressEditButton']/../p")
    private WebElement filledAddress;

    @FindBy(xpath = "//select[@id='destination-cac_country']")
    private WebElement country;

    @FindBy(xpath = "//span[@class='ups-lever_switch']")
    private WebElement verificationAddress;

    @FindBy(xpath = "//span[@class='ups-lever_switch_bg']")
    private WebElement residentialSwitch;

    @FindBy(xpath = "//input[@id='vm.residentialAddressControlId']")
    private WebElement residentialHiddenSwitch;

    @FindBy(xpath = "//span[@class='ups-lever_switch_bg']")
    private WebElement verificationButton;

    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement continueButton;


    public String getTextResultField(){
        return resultsField.getText();
    }

    public void selectCountry(String value) {
        new Select(country).selectByVisibleText(value);
    }

    public void fillName(String value) {
        name.sendKeys(value);
    }
    public void fillAddress(String value) {
        address.sendKeys(value);
        suggestionsList.get(0).click();
        assertThat(filledAddress.getText()).isEqualTo(value);
    }

    public String getVerificationAddress() throws InterruptedException {
//        Thread.sleep(1000);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='ups-lever_switch']")));
        return verificationAddress.getText();
    }

    public void checkVerificationAddress(){
        if(!residentialHiddenSwitch.isSelected()){
            residentialSwitch.click();
        }

        continueButton.click();
    }

    public void uncheckClickVerificationAddress(){
        if(residentialHiddenSwitch.isSelected()){
            residentialSwitch.click();
        }


        continueButton.click();
    }



}
