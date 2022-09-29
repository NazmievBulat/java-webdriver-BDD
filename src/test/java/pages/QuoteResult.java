package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult {
    public QuoteResult(){
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='well form-container container-fluid']")
    private WebElement resultContainer;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;


    public String getResultContainer(){
        return resultContainer.getText();
    }
    public String getPassword(){
        return password.getText();
    }
    public boolean isAgreedToPrivacyPolicy(){
        return Boolean.parseBoolean(agreedToPrivacyPolicy.getText());
    }
}
