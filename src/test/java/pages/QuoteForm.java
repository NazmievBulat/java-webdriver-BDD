package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static support.TestContext.getDriver;

public class QuoteForm extends Page{

    //constructor
    public QuoteForm(){
        PageFactory.initElements(getDriver(), this);
    }

    // fields
    private String url = "https://skryabin.com/market/quote.html";

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    //name dialog

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//span[(text()='Save')]")
    private WebElement save;

    //

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement agreePolicy;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;



    // Fields required message
    @FindBy(xpath = "//label[@id='username-error']")
    private List<WebElement> usernameError;
    @FindBy(xpath = "//label[@id='email-error']")
    private WebElement emailError;
    @FindBy(xpath = "//label[@id='password-error']")
    private WebElement passwordError;
    @FindBy(xpath = "//label[@id='name-error']")
    private WebElement nameError;
    @FindBy(xpath = "//label[@id='agreedToPrivacyPolicy-error']")
    private WebElement agreedToPrivacyPolicyError;




    //methods

    public void open(){
        getDriver().get(url);
    }
    public void fillUsername(String value){
        username.sendKeys(value);
    }

    public void fillEmail(String value){
        email.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue){
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();
    }

    public void fillPasswords(String value){
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void acceptPrivacyPolicy(){
        agreePolicy.click();
    }
    public void submit(){
        submitButton.click();
    }



//    public invUsernameError(){
//       return usernameError == usernameError.size = 0
//
//    }

    public int invUsernameError(){
        return usernameError.size();
    }

    public void invNameError() {
        if (!emailError.isDisplayed()) {

        }
    }

}
