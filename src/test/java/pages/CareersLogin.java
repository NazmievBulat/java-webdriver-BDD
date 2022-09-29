package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.Loggable;
import support.Screenshot;

import java.util.Map;

public class CareersLogin extends Page implements Loggable, Screenshot {

    @FindBy(xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submitButton;

    public void logIn(String username, String password){
        takeScreenshot();
        usernameField.sendKeys(username);
        getLogger().info("Filled out username " + username);
        passwordField.sendKeys(password);
        takeScreenshot();
        submitButton.click();
    }

    public void logIn(Map<String, String> user){
        logIn(user.get("email"), user.get("password"));

    }
}
