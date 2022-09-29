package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersHome extends Page{

    public CareersHome(){
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(css = ".fa.fa-fw.fa-sign-in")
    private WebElement logInButton;

    @FindBy(css = ".fa.fa-fw.fa-building")
    private WebElement recruitButton;

    @FindBy(css = ".fa.fa-fw.fa-briefcase")
    private WebElement myJobsButton;





    public void clickToLogIn(){
        logInButton.click();
    }



    public void verifyOpenPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(recruitButton));
    }

    public void clickToRecruitButton(){
        recruitButton.click();
    }


}
