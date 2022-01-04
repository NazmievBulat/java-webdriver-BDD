package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UnitConvertStepDefs {
    @And("I select {string} in menu")
    public void iSelectInMenu(String menuItem) {
        getDriver().findElement(By.xpath("//a[normalize-space()='"+menuItem+"']")).click();
    }

    @And("I fill out {string} {string}")
    public void iFillOut(String val, String meas) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(val);
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[text()='"+meas+"']")).click();
    }

    @Then("I verify result has {string} {string}")
    public void iVerifyThatHas(String val, String meas1) {
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'"+meas1+"')]")).click();
        String result =  getDriver().findElement(By.xpath("//div[@id='calResults']")).getText();
        assertThat(result).contains(val);


    }
}
