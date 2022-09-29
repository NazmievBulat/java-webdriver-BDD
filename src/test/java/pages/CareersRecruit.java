package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;

public class CareersRecruit extends Page {

    @FindBy(xpath = "//h4[contains(text(),'New Position')]")
    private WebElement createNewUserButton;


    private WebElement buttonDeleteElementByRole(String role) {

        return getDriver().findElement(By.xpath("//h4[normalize-space()='" + role + "']/ancestor::div[@class='card bg-white mb-3']//button"));
        //i[@class='fa fa-close']
    }

    private WebElement elementByRole(String role) {

        return getDriver().findElement(By.xpath("//h4[text()='" + role + "']/ancestor::div[@class='card bg-white mb-3']"));
    }


    public void deleteElementByRole(String role) {
        moveToElement(elementByRole(role));
//        clickWithJs(buttonDeleteElementByRole(role));
//        clickWithActions(buttonDeleteElementByRole(role));
        buttonDeleteElementByRole(role).click();
        getWait().until(ExpectedConditions.invisibilityOf(elementByRole(role)));
    }

    public boolean isElementByRole(String role) {

        try {
            return elementByRole(role).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void createNewUserButtonClick(){
        createNewUserButton.click();
    }

    public void waitElementByRoleIsVisible(String role){
        getWait().until(ExpectedConditions.visibilityOf(elementByRole(role)));
    }
}
