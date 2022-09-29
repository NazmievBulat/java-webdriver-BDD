package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewPosition extends Page {

    @FindBy(xpath = "//input[@placeholder='Enter position Title']")
    private WebElement titleField;

    @FindBy(xpath = "//textarea[@placeholder='Enter detailed Description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//input[@placeholder='City']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@class='form-control']")
    private WebElement stateSelectForm;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement calendar;

    @FindBy(xpath = "//div[@class='react-datepicker__today-button']")
    private WebElement todayButton;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submitButton;

    public void fillTitle(String value) {
        titleField.sendKeys(value);
    }

    public void fillDescription(String value) {
        descriptionField.sendKeys(value);
    }

    public void fillCity(String value) {
        cityField.sendKeys(value);
    }

    public void selectState(String value) {
        new Select(stateSelectForm).selectByVisibleText(value);
    }

    public void selectToday() {
        calendar.click();
        todayButton.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

}
