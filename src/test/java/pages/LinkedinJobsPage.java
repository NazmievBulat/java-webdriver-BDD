package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static support.TestContext.driver;

public class LinkedinJobsPage extends Page {
    @FindBy(xpath = "(//span[@class='artdeco-button__text'][normalize-space()='Easy Apply'])[1]")
    private List<WebElement> easyApplyList;

    @FindBy(xpath = "(//span[@class='artdeco-button__text'][normalize-space()='Easy Apply'])[1]")
    private WebElement easyApply;

    @FindBy(xpath = "(//li-icon[@type='cancel-icon'])[1]")
    private WebElement cancelButton;

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
    private List <WebElement> continueButton;

    @FindBy(xpath = "//span[normalize-space()='Done']")
    private WebElement doneButton;

    @FindBy(xpath = "(//span[@class='artdeco-button__text'][normalize-space()='Choose'])[1]")
    private WebElement chooseFirstResume;

    @FindBy(xpath = "(//span[@class='artdeco-button__text'][normalize-space()='Choose'])[1]")
    private List <WebElement> chooseFirstResumeList;

    @FindBy(xpath = "//*[text() ='Please enter a valid answer']")
    private List<WebElement> errorMessage;

    public static boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void applyForJobs() {

        int a = 0;

        for (int r = 2; r < 40; r++){
        for (int i = 0; i < 25; i++) {



            if (isClickable(easyApply)){

                try {
                    isClickable(easyApply);
                    easyApply.click();
                } catch (Exception ex) {
                }



                try {
                    next.click();
                    chooseFirstResume.click();
                }catch (Exception ex){
                    if (reviewList.size() > 0) {
                        isClickable(review);
                        review.click();
                        try {
                            isClickable(submit);
                            submit.click();
                            System.out.println("I applied for " + a + " applications");
                        }catch (org.openqa.selenium.NoSuchElementException ex1){
                            exitButton.click();
                            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                            wait.until(ExpectedConditions.elementToBeClickable(saveButton));

                            saveButton.click();
                        }



                        try{
                            isClickable(doneButton);

                            doneButton.click();
                        }
                        catch (org.openqa.selenium.NoSuchElementException ex2){
                            cancelButton.click();
                        }
                        a += 1;


                    }

                    else if (errorMessage.size() > 0) {

                        exitButton.click();
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                        wait.until(ExpectedConditions.elementToBeClickable(saveButton));

                        saveButton.click();
                    }
                }

                try {
                    chooseFirstResume.click();
                    submit.click();
                }catch (Exception ex){
                    continue;
                }


//                while (reviewList.size() == 0 && errorMessage.size() == 0 && listSubmit.size() == 0 && chooseFirstResumeList.size() == 0) {
//
//                    next.click();
//
//                }






            }
            else{
                i += 0.5;
                System.out.println("This is line " + i);
            }
            //int i = 0;


            try
            {
            WebElement element = driver.findElement(By.xpath("//div[contains(@class,'job-card-container--viewport-tracking-" + i + "')]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            js.executeScript("arguments[0].scrollIntoView(true);", element);

        }
            catch(org.openqa.selenium.NoSuchElementException ex){
                //System.out.println("Element does not exist!");


            }


//
//                if(i == 24){
//
//                }

        }


            WebElement page = driver.findElement(By.xpath("//button[@aria-label='Page " + r + "']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", page);

//        page.click();
            }

        }
    }

