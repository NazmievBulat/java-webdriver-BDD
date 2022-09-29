package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.*;
import static support.TestContext.driver;

public class Page {

    protected String url;
    protected String title;

    //constructor
    public Page(){
        PageFactory.initElements(getDriver(), this);
    }

    public void open(){
        getDriver().get(url);
    }

    public WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), getConfig().explicitTimeout);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void clickWithJs(WebElement element){
        js.executeScript("arguments[0].click", element);
    }

    public void scrollWindowWithJs(String pixel){
        js.executeScript("window.scrollBy(0,"+ pixel + ")");
    }

    public void clickWithActions(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }
    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


}

