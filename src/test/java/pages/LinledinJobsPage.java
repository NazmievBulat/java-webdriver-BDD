package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static support.TestContext.driver;

public class LinledinJobsPage extends Page {
    @FindBy(xpath = "(//span[@class='artdeco-button__text'][normalize-space()='Easy Apply'])[1]")
    private List<WebElement> easyApplyList;

    @FindBy(xpath = "(//span[@class='artdeco-button__text'][normalize-space()='Easy Apply'])[1]")
    private WebElement easyApply;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    private WebElement next;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    private List<WebElement> nextList;

    @FindBy(xpath = "//span[normalize-space()='Review']")
    private WebElement review;

    @FindBy(xpath = "//span[normalize-space()='Review']")
    private List<WebElement> reviewList;

    @FindBy(xpath = "//span[normalize-space()='Submit application']")
    private WebElement submit;

    @FindBy(xpath = "//span[normalize-space()='Submit application']")
    private List<WebElement> listSubmit;

    @FindBy(xpath =
            "//button[@class='artdeco-modal__dismiss artdeco-button artdeco-button--circle artdeco-button--muted artdeco-button--2 artdeco-button--tertiary ember-view']")
    private WebElement exitButton;
    @FindBy(xpath = "//span[@class='artdeco-button__text'][normalize-space()='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[text() ='Continue']")
    private WebElement anotherSubmit;

    @FindBy(xpath = "//span[normalize-space()='Done']")
    private WebElement doneButton;

    @FindBy(xpath = "//*[text() ='Please enter a valid answer']")
    private List<WebElement> errorMessage;

    public static boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void applyForJobs() {





        for (int i = 0; i < 25; i++)
        {
                if (easyApplyList.size() > 0) {


                    try {

                        easyApply.click();
                    }
                    catch(org.openqa.selenium.StaleElementReferenceException ex)
                    {

                        easyApply.click();
                    }
//                   easyApply.click();


                    while (nextList.size() > 0 && errorMessage.size() == 0) {

                        next.click();



                    }
                    if(reviewList.size() > 0){
                        review.click();
                    }
                    if (listSubmit.size() > 0) {
                        submit.click();
                        doneButton.click();

                    }
                    if(errorMessage.size() > 0) {
                        exitButton.click();
                        WebDriverWait wait = new WebDriverWait(driver, 3);
                        wait.until(ExpectedConditions.elementToBeClickable(saveButton));

                        saveButton.click();
                    }

                }
                //int i = 0;

                WebElement element = driver.findElement(By.xpath("//div[contains(@class,'job-card-container--viewport-tracking-" + i + "')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                js.executeScript("arguments[0].scrollIntoView(true);", element);


            }

        }
    }
