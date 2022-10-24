package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.driver;

public class LinledinLoginPage extends Page{
    @FindBy(xpath = "//input[@id='username']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement signInButton;


    public void loginIn() {
        email.sendKeys("login");
        password.sendKeys("password");
        signInButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.urlContains("https://www.linkedin.com/feed"));
    }
}
