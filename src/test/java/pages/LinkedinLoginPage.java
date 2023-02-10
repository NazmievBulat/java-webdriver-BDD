package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.driver;

public class LinkedinLoginPage extends Page{
    @FindBy(xpath = "//input[@id='username']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement signInButton;


    public void loginIn(String Login, String Password) {
        email.sendKeys("nazmievbulat@gmail.com");
        password.sendKeys("i4re3r2q");
        signInButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("https://www.linkedin.com/feed"));
    }
}
