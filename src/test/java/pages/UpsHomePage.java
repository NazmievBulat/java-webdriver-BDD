package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UpsHomePage extends Page{
//    //constructor
//    public UpsHomePage(){
//        PageFactory.initElements(getDriver(), this);
//    }

    // fields
    private String url = "https://www.ups.com/us/en/Home.page";

    @FindBy(css = ".nav-link.widget-link-ship")
    private WebElement shipButton;
    @FindBy(xpath = "//button[@class='close_btn_thick']")
    private WebElement closePopupButton;


    public void open(){
        getDriver().get(url);
    }
    public void goToShip(){
        shipButton.click();
    }
    public void closePopup(){
        if (closePopupButton.isDisplayed()){
        closePopupButton.click();
        }
    }
}
