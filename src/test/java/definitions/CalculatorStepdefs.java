package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CalculatorStepdefs {

    private final By autoPrice = By.xpath("//input[@id='cloanamount']");
    private final By loanTerm = By.xpath("//input[@id='cloanterm']");
    private final By interestRate = By.xpath("//input[@id='cinterestrate']");
    private final By downPayment = By.xpath("//input[@id='cdownpayment']");
    private final By tradeInValue = By.xpath("//input[@id='ctradeinvalue']");
    private final By yourState = By.xpath("//select[@name='cstate']");
    private final By salesTax = By.xpath("//input[@id='csaletax']");
    private final By regFee = By.xpath("//input[@id='ctitlereg']");
    private final By checkFees = By.xpath("//span[@class='cbmark']");
    private final By calculateButton = By.xpath("//input[@value='Calculate']");

    @When("I navigate to {string}")
    public void iNavigateTo(String calcType) {
        getDriver().findElement(By.xpath("//a[text()='"+calcType+"']")).click();

    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(autoPrice).clear();
        getDriver().findElement(loanTerm).clear();
        getDriver().findElement(interestRate).clear();
        getDriver().findElement(downPayment).clear();
        getDriver().findElement(tradeInValue).clear();
        //getDriver().findElement(yourState).clear();
        getDriver().findElement(salesTax).clear();
        getDriver().findElement(regFee).clear();
        //getDriver().findElement(checkFees).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(calculateButton).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        String result = getDriver().findElement(By.xpath("//td[@valign='top']//div/..")).getText();
        // Assertion error
        assertThat(result).contains(error);

    }

    @And("I enter {string} price, {string} months, {string} interest, " +
            "{string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(
            String price, String months, String interest,

            String downPaymentE, String tradeIn, String state,

            String percentTax, String fees) {
        getDriver().findElement(autoPrice).sendKeys(price);
        getDriver().findElement(loanTerm).sendKeys(months);
        getDriver().findElement(interestRate).sendKeys(interest);
        getDriver().findElement(downPayment).sendKeys(downPaymentE);
        getDriver().findElement(tradeInValue).sendKeys(tradeIn);
        WebElement countryMenu = getDriver().findElement(yourState);
        new Select(countryMenu).selectByVisibleText(state);
        getDriver().findElement(salesTax).sendKeys(percentTax);
        getDriver().findElement(regFee).sendKeys(fees);

    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthPay) {
        String result = getDriver().findElement(By.xpath("//td[@valign='top']/h2")).getText();
        assertThat(result).contains(monthPay);
    }
}
